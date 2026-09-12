package com.neon.connectneon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neon.connectneon.dto.alumnos.AlumnoRequest;
import com.neon.connectneon.dto.alumnos.AlumnoResponse;
import com.neon.connectneon.service.AlumnoService;

@RestController 
@RequestMapping ("/api/alumnos")
public class AlumnoController {

    public final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }


    @PostMapping 
    public ResponseEntity<AlumnoResponse> crearAlumno(@RequestBody AlumnoRequest request) {
        AlumnoResponse alumnoCreado = alumnoService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado);
    }

    @GetMapping 
    public ResponseEntity <List<AlumnoResponse>> listarAlumnos() {
        List<AlumnoResponse> alumnos = alumnoService.listar();
        return ResponseEntity.ok(alumnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponse> buscarPorID(@PathVariable Long id){

       AlumnoResponse alumno= alumnoService.buscarPorID(id);

       if(alumno == null){
           return  ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(alumno);
   }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponse> actualizar(@PathVariable Long id,@RequestBody AlumnoRequest request)
    {

        AlumnoResponse alumnoActualizado = alumnoService.actualizar(id,request);
        if(alumnoActualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alumnoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        boolean eliminado = alumnoService.eliminar(id);
        if(!eliminado){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
