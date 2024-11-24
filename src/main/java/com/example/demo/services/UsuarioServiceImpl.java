package com.example.demo.services;

import com.example.demo.dao.UsuarioRepository;
import com.example.demo.dto.Usuario;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    org.slf4j.Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Override
    public List<Usuario> GetAllUsuarios() {
        List<Usuario> Usuario= usuarioRepository.findAll();
        return Usuario;
    }

    @Override
    public Optional<Usuario> getUsuarioById(Long id){
        Optional<Usuario> searchUser= usuarioRepository.findById(id);
        if(searchUser.isPresent()){
            logger.error("Usuario encontrado!!");
            return searchUser;
        }else{
            logger.error("No se encontro el usuario" + id + "buscando");
            throw new NoSuchElementException("No se encontro el usuario" + id + "buscando");
        }
    }

    @Override
    public Optional<Usuario> CreateUsuario(Usuario usuario){
        Optional<Usuario> optUsuario=Optional.of(usuario);
        if(optUsuario.isPresent()){
            Usuario newUser= new Usuario();
            newUser.setNombre(usuario.getNombre());
            newUser.setApellidos(usuario.getApellidos());
            newUser.setDni(usuario.getDni());
            newUser.setSueldo(usuario.getSueldo());
            usuarioRepository.save(newUser);
            logger.info("Se ha creado el usuario correctamente");
            Optional<Usuario> rturnOptUser = Optional .of(newUser);
            return rturnOptUser;
        }else{
            logger.error("No se ha recibido un usuario para crear");
            throw new NoSuchElementException("No se ha recibido un usuario para crear");
        }
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario){
    Optional<Usuario> optUsuario = usuarioRepository.findById(id);
    if(optUsuario.isPresent()){
        Usuario usuarioUpdate = optUsuario.get();
        usuarioUpdate.setNombre(usuario.getNombre());
        usuarioUpdate.setApellidos(usuario.getApellidos());
        usuarioUpdate.setDni(usuario.getDni());
        usuarioUpdate.setSueldo(usuario.getSueldo());
        usuarioRepository.save(usuarioUpdate);
        logger.error("Usuario con id" + id + " actualizado correctamente");
        return usuarioUpdate;
    }else{
        logger.error("No se ha recibido un usuario para crear");
        throw new NoSuchElementException("No se ha recibido un usuario para crear");
    }
    }

    @Override
    public void deleteUsuarioById(Long id){
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isPresent()){
            Usuario usuarioTrust = optUsuario.get();
            usuarioRepository.deleteById(usuarioTrust.getId());
            logger.error("Usuario con Id " + id + " de forma efectiva");
        }else{
            logger.error("El usuario ha eliminar  no existe");
        }
    }
}
