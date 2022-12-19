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
    CommandLineRunner start(CategoryRepository categoryRepository, FilmRepository filmRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Film.class, Categorie.class);
        return args -> {
            filmRepository.save(new Film(null, "spider-man", "marvel movie", "marvel studios", new Date(), 2.5, "photo",
                    new Categorie(null, "Action")));
            filmRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }

}
