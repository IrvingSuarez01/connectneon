package com.neon.connectneon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neon.connectneon.dto.materias.MateriaRequest;
import com.neon.connectneon.dto.materias.MateriaResponse;
import com.neon.connectneon.service.MateriaService;


@RestController
@RequestMapping("/api/materias")
@CrossOrigin(origins = "http://localhost:5173")
public class MateriaController {

    private final MateriaService materiaservice;
    public MateriaController(MateriaService materiaservice) { this.materiaservice = materiaservice; }

  
    //http://localhost:8080/api/materias
   @PostMapping
    public ResponseEntity<MateriaResponse> crear(@RequestBody MateriaRequest request){
       MateriaResponse materiaCreado= materiaservice.crear(request);
       // 201
       return ResponseEntity.status(HttpStatus.CREATED).body(materiaCreado);

   }

   @GetMapping
    public ResponseEntity<List<MateriaResponse>> listar(){
       List<MateriaResponse> materias= materiaservice.listar();
       // 200ok
       return ResponseEntity.ok(materias);
   }


    @GetMapping("/{id}")
    public ResponseEntity<MateriaResponse> buscarPorID(@PathVariable Long id){

       MateriaResponse materia= materiaservice.buscarPorID(id);
       if(materia == null){
           return  ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(materia);
   }


    @PutMapping("/{id}")
    public ResponseEntity<MateriaResponse> actuzalizar(@PathVariable Long id,@RequestBody MateriaRequest request)
    {

        MateriaResponse materiaActulziada = materiaservice.actualizar(id,request);
        if(materiaActulziada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(materiaActulziada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        boolean eliminado = materiaservice.eliminar(id);
        if(!eliminado){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
