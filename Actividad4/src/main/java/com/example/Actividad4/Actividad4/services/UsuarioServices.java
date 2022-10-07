package com.example.Actividad4.Actividad4.services;

import com.example.Actividad4.Actividad4.dao.Dao;
import com.example.Actividad4.Actividad4.model.Usuario;

import java.util.Iterator;
import java.util.List;

public class UsuarioServices implements ICrudService<Usuario> {
    @Override
    public List<Usuario> findAll(Long id) {
        return Dao.getInstance().getListaUsuarios();
    }

    @Override
    public List<Usuario> save(Usuario usuario,Long id) {
        Dao.getInstance().getListaUsuarios().add(usuario);
        return Dao.getInstance().getListaUsuarios();
    }

    @Override
    public Usuario update(Long id,Usuario user) {
        for(int i=0; i<Dao.getInstance().getListaUsuarios().size();i++){
            Usuario usuario = Dao.getInstance().getListaUsuarios().get(i);
            if(usuario.getId() == id){
                usuario.setPeliculas(user.getPeliculas());
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> updateList(Long id, Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> delete(Long id, String name) {
        Iterator it = Dao.getInstance().getListaUsuarios().iterator();
        while (it.hasNext()){
            Usuario u = (Usuario) it.next();
            if(u.getId() == id){
                it.remove();
            }
        }
        return Dao.getInstance().getListaUsuarios();
    }
}
