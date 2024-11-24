package com.example.demo.services;


import com.example.demo.dto.Usuario;
import java.util.List;
import java.util.Optional;


public interface UsuarioService {
    List<Usuario> GetAllUsuarios();
    Optional<Usuario> getUsuarioById(Long id);
    Optional<Usuario> CreateUsuario(Usuario Usuario);
    Usuario updateUsuario(Long id, Usuario usuario);
    void deleteUsuarioById(Long id);
    
}


