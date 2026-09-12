package com.neon.connectneon.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.neon.connectneon.dto.materias.MateriaRequest;
import com.neon.connectneon.dto.materias.MateriaResponse;
import com.neon.connectneon.model.Materia;
import com.neon.connectneon.repository.MateriaRepository;

@Service
public class MateriaService {

    private final MateriaRepository  materiaRepository;

    public MateriaService(MateriaRepository materiaRepository){
        this.materiaRepository=materiaRepository;
    }

    public MateriaResponse crear(MateriaRequest request){
                
        Materia materia = new Materia();
        materia.setNombre(request.getNombre());
        materia.setCreditos_necesarios(request.getCreditosNecesarios());
        
        Materia materiaGuardada= materiaRepository.save(materia);
        return convertirAResponse(materiaGuardada);

    }

    public List<MateriaResponse> listar(){
        return  materiaRepository.findAll().stream().map(this::convertirAResponse).toList();

    }


    public MateriaResponse buscarPorID(Long id){
        return  materiaRepository.findById(id).map(this::convertirAResponse).orElse(null);
    }



    public MateriaResponse actualizar(Long id, MateriaRequest request){

        Materia materia = materiaRepository.findById(id).orElse(null);

        if(materia == null){
            return null;
        }

        materia.setNombre(request.getNombre());
        materia.setCreditos_necesarios(request.getCreditosNecesarios());

        Materia materiaActualizada= materiaRepository.save(materia);
        return convertirAResponse(materiaActualizada);

    }
 
    public boolean eliminar(Long id){
        if(!materiaRepository.existsById(id)){
            return  false;
        }
        materiaRepository.deleteById(id);
        return true;
    }


    public MateriaResponse convertirAResponse(Materia materia){
        return new MateriaResponse(materia.getId(),materia.getNombre(), materia.getCreditos_necesarios());
    }

}