package pe.edu.cibertec.appformsbasedatos.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appformsbasedatos.model.bd.Rol;
import pe.edu.cibertec.appformsbasedatos.model.bd.Usuario;
import pe.edu.cibertec.appformsbasedatos.repository.RolRepository;
import pe.edu.cibertec.appformsbasedatos.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UsuarioService {
/*    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public Usuario findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Usuario findUserByUserName(String username) {
        return userRepository.findByNomusuario(username);
    }

    public Usuario saveUser(Usuario user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActivo(true);
        //Esto puede ser dinámico
        Rol userRol = rolRepository.findByNomrol("ADMIN");
        user.setRoles(new HashSet<Rol>(Arrays.asList(userRol)));
        return userRepository.save(user);
    }*/

}
