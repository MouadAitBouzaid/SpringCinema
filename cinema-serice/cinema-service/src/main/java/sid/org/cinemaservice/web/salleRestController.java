package sid.org.cinemaservice.web;


import org.springframework.web.bind.annotation.*;
import sid.org.cinemaservice.entities.Salle;
import sid.org.cinemaservice.repository.SalleRepository;

import java.util.List;


@RestController
public class SalleRestController {
    private SalleRepository salleRepository;
    public SalleRestController(SalleRepository salleRepository){
        this.salleRepository=salleRepository;
    }
    @GetMapping("/salles")
    public List<Salle> salles(){
        return salleRepository.findAll();    }
    @GetMapping("/salles/{id}")
    public Salle salles(@PathVariable Long id){
        return salleRepository.findById(id)
                .orElseThrow();    }
    @PostMapping("/salles")
    public Salle saveSalle(@RequestBody Salle Salle){
        return salleRepository.save(Salle);
    }
    @PutMapping("/salles/{id}")
    public Salle updateSalle(@PathVariable Long id,@RequestBody Salle salle){
        Salle salle1=salles(id);
        if(salle.getId()!=null) salle1.setName(salle.getName());
        if(salle.getId()!=null) salle1.setId(salle.getId());
        if(salle.getNbrPlaces()!= 0) salle1.setNbrPlaces(salle.getNbrPlaces());
        return saveSalle(salle1);
    }
    @DeleteMapping("/salles/{id}")
    public void deleteSalle(@PathVariable Long id){
        salleRepository.deleteById(id);

    }

}
