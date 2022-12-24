package ord.sid.filmservice;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.servlet.ServletOutputStream;
import ord.sid.filmservice.entities.Categorie;
import ord.sid.filmservice.entities.Film;
import ord.sid.filmservice.repository.CategoryRepository;
import ord.sid.filmservice.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class FilmServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(FilmServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository, FilmRepository filmRepository){
        return args -> {
            filmRepository.save(new Film(null, "Up", "film pour enfant", "john", new Date(), 2, "true", "photo"));
            filmRepository.save(new Film(null, "SpiderMan", "+6ans", "joe", new Date(), 1.45 , "true", "photo"));
            filmRepository.save(new Film(null, "Green-Mile", "pensionnaire centenaire", "Frank Darabont", new Date(), 1.56 , "true", "photo"));
            categoryRepository.save(new Categorie(null, "Action"));
            categoryRepository.save(new Categorie(null, "Adventure"));
            categoryRepository.save(new Categorie(null, "thriller"));
            categoryRepository.save(new Categorie(null, "Comedi"));
            categoryRepository.save(new Categorie(null, "Fantasy"));
            filmRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }

}
