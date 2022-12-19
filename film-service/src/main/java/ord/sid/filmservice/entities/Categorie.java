package ord.sid.filmservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    /*@OneToMany(mappedBy = "categorie")
    private Collection<Film> films;
     */
}
