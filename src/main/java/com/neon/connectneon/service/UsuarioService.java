package com.neon.connectneon.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.neon.connectneon.dto.usuario.*;
import com.neon.connectneon.model.Usuario;
import com.neon.connectneon.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository  usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    public UsuarioResponse crear(UsuarioRequest request){
        //Crear una nueva endiad
        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getEmail());

      Usuario usuarioGuardado= usuarioRepository.save(usuario);

      return convertirAResponse(usuarioGuardado);

    }

    public List<UsuarioResponse> listar(){
        return  usuarioRepository.findAll().stream().map(this::convertirAResponse).toList();

    }


    public UsuarioResponse buscarPorID(Long id){
        return  usuarioRepository.findById(id).map(this::convertirAResponse).orElse(null);
    }


    //actualziar
    public UsuarioResponse actualizar(Long id, UsuarioRequest request){

        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if(usuario == null){
            return null;
        }

        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getEmail());

        Usuario usuarioActulizado= usuarioRepository.save(usuario);

        return convertirAResponse(usuarioActulizado);

    }

    public boolean eliminar(Long id){
        if(!usuarioRepository.existsById(id)){
            return  false;
        }
        usuarioRepository.deleteById(id);
        return true;
    }


    public UsuarioResponse convertirAResponse(Usuario usuario){
        return new UsuarioResponse(usuario.getId(),usuario.getNombre(), usuario.getEmail());
    }

}