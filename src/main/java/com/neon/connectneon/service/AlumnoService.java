package com.neon.connectneon.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.neon.connectneon.dto.alumnos.AlumnoRequest;
import com.neon.connectneon.dto.alumnos.AlumnoResponse;
import com.neon.connectneon.model.Alumno;
import com.neon.connectneon.repository.AlumnoRepository;


@Service
public class AlumnoService {

    private final AlumnoRepository  alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository){
        this.alumnoRepository=alumnoRepository;
    }

    public AlumnoResponse crear(AlumnoRequest request){
                
        Alumno alumno = new Alumno();
        alumno.setNombre(request.getNombre());
        alumno.setApellido(request.getApellido());
        alumno.setMatricula(request.getMatricula());
        alumno.setSemestre(request.getSemestre());
        alumno.setTelefono(request.getTelefono());
        alumno.setCreditos_acumulados(request.getCreditos_acumulados());
        
        Alumno alumnoGuardado= alumnoRepository.save(alumno);
        return convertirAResponse(alumnoGuardado);

    }

    public List<AlumnoResponse> listar(){
        return  alumnoRepository.findAll().stream().map(this::convertirAResponse).toList();

    }


    public AlumnoResponse buscarPorID(Long id){
        return  alumnoRepository.findById(id).map(this::convertirAResponse).orElse(null);
    }



    public AlumnoResponse actualizar(Long id, AlumnoRequest request){

        Alumno alumno = alumnoRepository.findById(id).orElse(null);

        if(alumno == null){
            return null;
        }

        alumno.setNombre(request.getNombre());
        alumno.setApellido(request.getApellido());
        alumno.setMatricula(request.getMatricula());
        alumno.setSemestre(request.getSemestre());
        alumno.setTelefono(request.getTelefono());
        alumno.setCreditos_acumulados(request.getCreditos_acumulados());

        Alumno alumnoActualizado= alumnoRepository.save(alumno);
        return convertirAResponse(alumnoActualizado);

    }
 
    public boolean eliminar(Long id){
        if(!alumnoRepository.existsById(id)){
            return  false;
        }
        alumnoRepository.deleteById(id);
        return true;
    }


    public AlumnoResponse convertirAResponse(Alumno alumno){
        return new AlumnoResponse(alumno.getId(), alumno.getNombre(), alumno.getApellido(), alumno.getMatricula(), alumno.getSemestre(), alumno.getTelefono(), alumno.getCreditos_acumulados());
    }

}