package pe.edu.cibertec.appformsbasedatos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appformsbasedatos.model.bd.Rol;
import pe.edu.cibertec.appformsbasedatos.model.bd.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DetalleUsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario user = usuarioService.findUserByUserName(username);
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Rol> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for(Rol role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getNomrol()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(Usuario user,
                                                   List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getNomusuario(), user.getPassword(), user.getActivo(),
                true, true, true, authorities);
    }
}
