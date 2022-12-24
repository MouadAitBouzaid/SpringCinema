package ord.sid.filmservice.web;

import ord.sid.filmservice.entities.Categorie;
import ord.sid.filmservice.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategorieController {
    private CategoryRepository categoryRepository;
    public CategorieController(CategoryRepository categoryRepository){
        this.categoryRepository= categoryRepository;
    }
    @GetMapping("/categories")
    public List<Categorie> categories(){
        return categoryRepository.findAll();    }
    @GetMapping("/categories/{id}")
    public Categorie categories(@PathVariable Long id){
        return categoryRepository.findById(id)
                .orElseThrow();    }
    @PostMapping("/categories")
    public Categorie saveCategorie(@RequestBody Categorie categorie ){
        return categoryRepository.save(categorie);
    }

}
