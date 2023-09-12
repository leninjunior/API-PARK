package com.lenin.demoparkapi.service;


import com.lenin.demoparkapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    //Injeção de Dependência com lombok
    private  final UsuarioRepository usuarioRepository;



}
