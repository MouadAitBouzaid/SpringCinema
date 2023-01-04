package sid.org.cinemaservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sid.org.cinemaservice.entities.Place;

@RepositoryRestResource
public interface PlaceRepository extends JpaRepository<Place, Long> {

}
