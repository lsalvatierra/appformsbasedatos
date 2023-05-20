package pe.edu.cibertec.appformsbasedatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.appformsbasedatos.model.bd.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);

    Usuario findByNomusuario(String username);
}
