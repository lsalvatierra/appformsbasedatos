package pe.edu.cibertec.appformsbasedatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appformsbasedatos.model.bd.Estado;
import pe.edu.cibertec.appformsbasedatos.model.bd.Sala;
import pe.edu.cibertec.appformsbasedatos.model.request.SalaRequest;
import pe.edu.cibertec.appformsbasedatos.model.response.ResultadoResponse;
import pe.edu.cibertec.appformsbasedatos.service.SalaService;

import java.util.List;

@Controller
@RequestMapping("/Sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping("/frmMantSala")
    public String frmMantSala(Model model){
        model.addAttribute("listaSalas",
                salaService.listarSalas());
        return "Sala/frmMantSala";
    }

    @PostMapping("/registrarSala")
    @ResponseBody
    public ResultadoResponse registrarSala(@RequestBody
                                               SalaRequest salaRequest){
        String mensaje = "Sala registrada correctamente";
        Boolean respuesta = true;
        try{
            Sala objSala = new Sala();
            if(salaRequest.getIdsala() > 0){
                objSala.setIdsala(salaRequest.getIdsala());
            }
            objSala.setDescsala(salaRequest.getDescsala());
            objSala.setAsientos(salaRequest.getAsientos());
            Estado objEstado = new Estado();
            objEstado.setIdestado(salaRequest.getIdestado());
            objSala.setEstado(objEstado);
            salaService.registrarSala(objSala);
        }catch (Exception ex){
            mensaje = "Sala no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarSala")
    @ResponseBody
    public ResultadoResponse eliminarSala(@RequestBody
                                              SalaRequest salaRequest){
        String mensaje = "Sala eliminada correctamente";
        Boolean respuesta = true;
        try{
            salaService.eliminarSala(salaRequest.getIdsala());
        }catch (Exception ex){
            mensaje = "Sala no eliminada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/listarSalas")
    @ResponseBody
    public List<Sala> listarSalas(){
        return salaService.listarSalas();
    }


}
