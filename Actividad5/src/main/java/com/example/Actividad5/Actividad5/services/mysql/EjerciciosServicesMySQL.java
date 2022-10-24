package com.example.Actividad5.Actividad5.services.mysql;

import com.example.Actividad5.Actividad5.conexion.MySql;
import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.entities.enums.Recuperacion;
import com.example.Actividad5.Actividad5.entities.enums.Resistencia;
import com.example.Actividad5.Actividad5.entities.enums.Velocidad;
import com.example.Actividad5.Actividad5.services.IEjerciciosServices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EjerciciosServicesMySQL implements IEjerciciosServices<Ejercicio> {
    @Override
    public List<Ejercicio> getAll() throws SQLException {
        List<Ejercicio> lista = new ArrayList<>();
        ResultSet rs = MySql.getInstance().createStatement().executeQuery("SELECT id,titulo FROM ejercicios;");
        while(rs.next()){
            Ejercicio e = new Ejercicio(rs.getString("titulo"),null,new ArrayList<>(),null,new HashMap<>(),new ArrayList<>(),new HashMap<>());
            e.setId(rs.getLong("id"));
            lista.add(e);
        }
        return lista;
    }

    @Override
    public Ejercicio getById(Long id) throws SQLException {
        Ejercicio e = null;
        ResultSet rs = MySql.getInstance().createStatement().executeQuery("SELECT * FROM ejercicios WHERE id= "+ id+";");
        HashMap<String,String> dureza = new HashMap<>();
        while(rs.next()){
            dureza.put("resistencia", Resistencia.getValor(rs.getInt("resistencia")));
            dureza.put("velocidad", Velocidad.getValor(rs.getInt("velocidad")));
            dureza.put("recuperacion", Recuperacion.getValor(rs.getInt("recuperacion")));
            e = new Ejercicio(rs.getString("titulo"),rs.getString("descripcion"),new ArrayList<>(),rs.getString("duracion"),dureza,new ArrayList<>(),new HashMap<String,String>());
            e.setId(rs.getLong("id"));
            e.setDurezaMedia(rs.getLong("dureza"));
        }
        ResultSet et = MySql.getInstance().createStatement().executeQuery("SELECT descripcion FROM etiquetas WHERE id_ejercicio= "+id+";");
        while (et.next()){
            e.getEtiquetas().add(et.getString("descripcion"));
        }
        ResultSet mat = MySql.getInstance().createStatement().executeQuery("SELECT descripcion FROM materiales WHERE id_ejercicio= "+id+";");
        while (mat.next()){
            e.getMateriales().add(mat.getString("descripcion"));
        }
        ResultSet req = MySql.getInstance().createStatement().executeQuery("SELECT * FROM recursosMultimedia WHERE id_ejercicio= "+id+";");
        while (req.next()){
            e.getRecursosMultimedia().put(req.getString("clave"), req.getString("valor"));
        }
        return e;
    }

    @Override
    public Ejercicio save(Ejercicio e) throws SQLException {
        e.calculaDurezaMedia();
        int resistencia = Resistencia.valueOf(e.getDureza().get("resistencia")).getNumero();
        int velocidad = Velocidad.valueOf(e.getDureza().get("velocidad")).getNumero();
        int recuperacion = Recuperacion.valueOf(e.getDureza().get("recuperacion")).getNumero();
        String query = "INSERT INTO ejercicios(id,titulo,descripcion,duracion,resistencia,velocidad,recuperacion,dureza) VALUES("+e.getId()+
                ",'"+e.getTitulo()+"','"+e.getDescripcion()+"','"+e.getDuracion()+"','"+resistencia+"','"+ velocidad+
                "','"+recuperacion+"',"+e.getDurezaMedia()+");";
        MySql.getInstance().createStatement().execute(query);
        for(String mat : e.getMateriales()){
            query = "INSERT INTO materiales VALUES("+e.getId()+",'"+mat+"');";
            MySql.getInstance().createStatement().execute(query);
        }
        for(String et : e.getEtiquetas()){
            query = "INSERT INTO etiquetas VALUES("+e.getId()+",'"+et+"');";
            MySql.getInstance().createStatement().execute(query);
        }
        for(String key : e.getRecursosMultimedia().keySet()){
            String clave = key;
            String valor = e.getRecursosMultimedia().get(clave);
            query = "INSERT INTO recursosMultimedia VALUES("+e.getId()+",'"+clave+"','"+valor+"');";
            MySql.getInstance().createStatement().execute(query);
        }
        return e;
    }
}
