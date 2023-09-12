package com.lenin.demoparkapi.service;


import com.lenin.demoparkapi.entity.Usuario;
import com.lenin.demoparkapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    //Injeção de Dependência com lombok
    private  final UsuarioRepository usuarioRepository;


    @Transactional
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
