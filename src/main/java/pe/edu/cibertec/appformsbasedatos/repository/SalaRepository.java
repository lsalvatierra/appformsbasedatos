package pe.edu.cibertec.appformsbasedatos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.appformsbasedatos.model.bd.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

}
