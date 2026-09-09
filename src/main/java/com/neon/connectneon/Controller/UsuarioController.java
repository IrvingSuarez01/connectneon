package com.neon.connectneon.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neon.connectneon.dto.UsuarioRequest;
import com.neon.connectneon.dto.UsuarioResponse;
import com.neon.connectneon.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usurioservice;

    public UsuarioController(UsuarioService usurioservice) { this.usurioservice = usurioservice; }

    //http://localhost:8080/api/usuarios
   @PostMapping
    public ResponseEntity<UsuarioResponse> crear(@RequestBody UsuarioRequest request){
       UsuarioResponse usuarioCreado= usurioservice.crear(request);
       // 201
       return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);

   }

   @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listar(){
       List<UsuarioResponse> usuarios= usurioservice.listar();
       // 200ok
       return ResponseEntity.ok(usuarios);
   }
}
