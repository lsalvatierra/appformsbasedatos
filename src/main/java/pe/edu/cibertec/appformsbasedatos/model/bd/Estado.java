package pe.edu.cibertec.appformsbasedatos.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestado;

    @Column(name = "descestado")
    private String descestado;

    @JsonManagedReference
    @OneToMany(mappedBy = "estado",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sala> listasala = new ArrayList<>();
}
