package pe.edu.cibertec.appformsbasedatos.controller;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.appformsbasedatos.model.bd.Usuario;
import pe.edu.cibertec.appformsbasedatos.service.UsuarioService;

@Controller
@RequestMapping("/auth")
@Transactional
public class LoginController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "Auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "Auth/registro";
    }


    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario user) {
        usuarioService.saveUser(user);
        return "Auth/login";
    }
}
