package pe.edu.cibertec.appformsbasedatos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appformsbasedatos.model.bd.Estado;
import pe.edu.cibertec.appformsbasedatos.repository.EstadoRepository;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> listarEstados(){
        return estadoRepository.findAll();
    }

    public void registrarEstado(Estado estado){
        estadoRepository.save(estado);
    }

    public void eliminarEstado(Estado estado){
        estadoRepository.deleteById(estado.getIdestado());
    }

}
