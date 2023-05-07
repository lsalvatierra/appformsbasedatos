package pe.edu.cibertec.appformsbasedatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.appformsbasedatos.model.bd.Estado;
import pe.edu.cibertec.appformsbasedatos.service.EstadoService;

import java.util.List;

@Controller
@RequestMapping("/Estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/frmMantEstado")
    public String frmMantEstado(Model model){
        model.addAttribute("listaEstados", estadoService.listarEstados());
        return "Estado/frmMantEstado";
    }

    @GetMapping("/listarEstados")
    @ResponseBody
    public List<Estado> listarEstados(){
        return estadoService.listarEstados();
    }

}
