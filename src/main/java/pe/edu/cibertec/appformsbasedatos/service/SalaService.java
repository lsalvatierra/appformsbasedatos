package pe.edu.cibertec.appformsbasedatos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appformsbasedatos.model.bd.Sala;
import pe.edu.cibertec.appformsbasedatos.repository.SalaRepository;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> listarSalas(){
        return salaRepository.findAll();
    }
    public void registrarSala(Sala sala){
        salaRepository.save(sala);
    }
    public void eliminarSala(Integer idSala){
        salaRepository.deleteById(idSala);
    }
}
