package com.example.Actividad5.Actividad5.services.mysql;

import com.example.Actividad5.Actividad5.conexion.MySql;
import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.entities.Entrenamiento;
import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.entities.enums.Recuperacion;
import com.example.Actividad5.Actividad5.entities.enums.Resistencia;
import com.example.Actividad5.Actividad5.entities.enums.Velocidad;
import com.example.Actividad5.Actividad5.services.IEntrenamientosServices;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntrenamientosServicesMySQL implements IEntrenamientosServices<Entrenamiento> {
    @Override
    public List<Entrenamiento> getAll() throws SQLException {
        List<Entrenamiento> lista = new ArrayList<>();
        ResultSet rs = MySql.getInstance().createStatement().executeQuery("SELECT * FROM entrenamientos;");
        while(rs.next()){
            Entrenamiento e = new Entrenamiento(rs.getDate("fecha"),null,null,null);
            e.setId(rs.getLong("id"));
            lista.add(e);
        }
        return lista;
    }

    @Override
    public Entrenamiento getById(Long id) throws SQLException {
        Entrenamiento en = null;
        ResultSet rs = MySql.getInstance().createStatement().executeQuery("SELECT * FROM entrenamientos WHERE id="+id+";");
        while(rs.next()){
            en = new Entrenamiento(rs.getDate("fecha"),new ArrayList<>(),new ArrayList<>(),rs.getLong("durezaMedia"));
            en.setId(rs.getLong("id"));
        }
        String query = "SELECT * FROM jugadores WHERE id in ("+
                "SELECT id_jugador FROM reservaEntrenamientos WHERE id_entrenamiento ="+id+");";
        ResultSet js = MySql.getInstance().createStatement().executeQuery(query);
        while (js.next()){
            Jugador j = new Jugador(js.getString("dni"),js.getString("nombre"),js.getString("apellidos"),js.getDate("fechaNacimiento"),
                    Resistencia.valueOf(Resistencia.getValor(js.getInt("resistencia"))),Velocidad.valueOf(Velocidad.getValor(js.getInt("velocidad"))),
                    Recuperacion.valueOf(Recuperacion.getValor(js.getInt("recuperacion"))));
            en.getAsistentes().add(j);
        }
        query = "SELECT * FROM ejercicios WHERE id in (SELECT id_ejercicio FROM entrenamientos_ejercicios " +
                "WHERE id_entrenamiento ="+id+");";
        ResultSet ejs = MySql.getInstance().createStatement().executeQuery(query);
        while (ejs.next()){
            Ejercicio ej = new Ejercicio(ejs.getString("titulo"),ejs.getString("descripcion"),new ArrayList<>(),ejs.getString("duracion"),
                    new HashMap<String,Integer>(),new ArrayList<>(),new HashMap<String,String>());
            ej.getDureza().put("resistencia",ejs.getInt("resistencia"));
            ej.getDureza().put("velocidad",ejs.getInt("velocidad"));
            ej.getDureza().put("recuperacion",ejs.getInt("recuperacion"));
            ej.setId(ejs.getLong("id"));
            ej.setDurezaMedia(ejs.getLong("dureza"));
            en.getEjercicios().add(ej);
        }
        if(en != null){
            for(Ejercicio ej : en.getEjercicios()){
                ResultSet et = MySql.getInstance().createStatement().executeQuery("SELECT descripcion FROM etiquetas WHERE id_ejercicio= "+ej.getId()+";");
                while (et.next()){
                    ej.getEtiquetas().add(et.getString("descripcion"));
                }
                ResultSet mat = MySql.getInstance().createStatement().executeQuery("SELECT descripcion FROM materiales WHERE id_ejercicio= "+ej.getId()+";");
                while (mat.next()){
                    ej.getMateriales().add(mat.getString("descripcion"));
                }
                ResultSet req = MySql.getInstance().createStatement().executeQuery("SELECT * FROM recursosMultimedia WHERE id_ejercicio= "+ej.getId()+";");
                while (req.next()){
                    ej.getRecursosMultimedia().put(req.getString("clave"), req.getString("valor"));
                }
            }
        }
        return en;
    }

    @Override
    public Entrenamiento save(Entrenamiento en) throws SQLException {
        en.calculaDurezaMedia();

        String pattern = "yyyy-MM-dd' 'HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fechaFormat = simpleDateFormat.format(en.getFecha());

        String query = "INSERT INTO entrenamientos (durezaMedia,fecha) VALUES ("+
                en.getDurezaMedia()+",'"+fechaFormat+"');";
        MySql.getInstance().createStatement().execute(query);

        if(en.getAsistentes() != null){
            for(Jugador j : en.getAsistentes()){
                query = "INSERT INTO reservaEntrenamientos (id_jugador,id_entrenamiento) VALUES" +
                        " ("+j.getId()+","+en.getId()+");";
                MySql.getInstance().createStatement().execute(query);
            }
        }

        for(Ejercicio e : en.getEjercicios()){
            e.calculaDurezaMedia();
            query = "INSERT INTO ejercicios VALUES ("+e.getId()+",'"+e.getTitulo()+"','"+
                    e.getDescripcion()+"','"+e.getDuracion()+"',"+e.getDureza().get("resistencia")+","+e.getDureza().get("velocidad")+
                    ","+e.getDureza().get("recuperacion")+","+e.getDurezaMedia()+");";
            MySql.getInstance().createStatement().execute(query);
            query = "INSERT INTO entrenamientos_ejercicios VALUES("+e.getId()+","+en.getId()+");";
            MySql.getInstance().createStatement().execute(query);
        }
        return en;
    }

    @Override
    public Entrenamiento update(Long id, List<Jugador> asistentes) throws SQLException { //TODO
        MySql.getInstance().createStatement().execute("DELETE FROM reservaEntrenamientos WHERE id_entrenamiento= "+id+";");
        for(Jugador j : asistentes){
            String query = "INSERT INTO reservaEntrenamientos VALUES ("+j.getId()+","+id+");";
            MySql.getInstance().createStatement().execute(query);
        }
        /////////////////////////////////// AQUI DEBAJO RECOGEMOS LO QUE DEVUELVE ///////////////////////////////////////////////////////////
        Entrenamiento resultado = null;
        ResultSet rs = MySql.getInstance().createStatement().executeQuery("SELECT * FROM entrenamientos WHERE id="+id+";");
        while(rs.next()){
            resultado = new Entrenamiento(rs.getDate("fecha"),new ArrayList<>(),new ArrayList<>(),null);
            resultado.setId(rs.getLong("id"));
        }
        String query = "SELECT * FROM jugadores WHERE id in ("+
                "SELECT id_jugador FROM reservaEntrenamientos WHERE id_entrenamiento ="+id+");";
        ResultSet js = MySql.getInstance().createStatement().executeQuery(query);
        while (js.next()){
            Jugador j = new Jugador(js.getString("dni"),js.getString("nombre"),js.getString("apellidos"),js.getDate("fechaNacimiento"),
                    Resistencia.valueOf(Resistencia.getValor(js.getInt("resistencia"))),Velocidad.valueOf(Velocidad.getValor(js.getInt("velocidad"))),
                    Recuperacion.valueOf(Recuperacion.getValor(js.getInt("recuperacion"))));
            j.setId(js.getLong("id"));
            resultado.getAsistentes().add(j);
        }
        query = "SELECT * FROM ejercicios WHERE id in (SELECT id_ejercicio FROM entrenamientos_ejercicios " +
                "WHERE id_entrenamiento ="+id+");";
        ResultSet ejs = MySql.getInstance().createStatement().executeQuery(query);
        while (ejs.next()){
            Ejercicio ej = new Ejercicio(ejs.getString("titulo"),ejs.getString("descripcion"),new ArrayList<>(),ejs.getString("duracion"),
                    new HashMap<String,Integer>(),new ArrayList<>(),new HashMap<String,String>());
            ej.getDureza().put(Resistencia.getValor(ejs.getInt("resistencia")),ejs.getInt("resistencia"));
            ej.getDureza().put(Velocidad.getValor(ejs.getInt("velocidad")),ejs.getInt("velocidad"));
            ej.getDureza().put(Recuperacion.getValor(ejs.getInt("recuperacion")),ejs.getInt("recuperacion"));
            ej.setId(ejs.getLong("id"));
            resultado.getEjercicios().add(ej);
            resultado.calculaDurezaMedia();
        }
        return resultado;
    }

    @Override
    public List<Entrenamiento> delete(Long id) throws SQLException {
        MySql.getInstance().createStatement().execute("DELETE FROM reservaEntrenamientos WHERE id_entrenamiento="+id+";");
        MySql.getInstance().createStatement().execute("DELETE FROM entrenamientos_ejercicios WHERE id_entrenamiento="+id+";");
        MySql.getInstance().createStatement().execute("DELETE FROM entrenamientos WHERE id="+id+";");
        List<Entrenamiento> lista = new ArrayList<>();
        ResultSet rs = MySql.getInstance().createStatement().executeQuery("SELECT * FROM entrenamientos;");
        while(rs.next()){
            Entrenamiento e = new Entrenamiento(rs.getDate("fecha"),null,null,null);
            e.setId(rs.getLong("id"));
            lista.add(e);
        }
        return lista;
    }
}