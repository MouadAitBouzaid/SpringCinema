package ord.sid.filmservice.web;

import ord.sid.filmservice.entities.Categorie;
import ord.sid.filmservice.entities.Film;
import ord.sid.filmservice.repository.CategoryRepository;
import ord.sid.filmservice.repository.FilmRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class FilmController {
    private FilmRepository filmRepository;
    public FilmController(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }
    @GetMapping("/films")
    public List<Film> films(){
        return filmRepository.findAll();    }
    @GetMapping("/films/{id}")
    public Film films(@PathVariable Long id){
        return filmRepository.findById(id)
                .orElseThrow();    }
    @PostMapping("/films")
    public Film saveFilm(@RequestBody Film film ){
        return filmRepository.save(film);
    }

}
