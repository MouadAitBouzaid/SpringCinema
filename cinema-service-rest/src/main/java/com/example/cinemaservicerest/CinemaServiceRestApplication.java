package com.example.cinemaservicerest;

import com.example.cinemaservicerest.entities.Place;
import com.example.cinemaservicerest.entities.Salle;
import com.example.cinemaservicerest.repository.PlaceRepository;
import com.example.cinemaservicerest.repository.SalleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CinemaServiceRestApplication {

    public static void main(String[] args) {

        SpringApplication.run(CinemaServiceRestApplication.class, args);
    }
    @Bean
    CommandLineRunner start(SalleRepository salleRepository, PlaceRepository placeRepository){
        return args -> {
            salleRepository.save(new Salle(null,"salle1",50));
            salleRepository.save(new Salle(null,"salle2",50));
            salleRepository.save(new Salle(null,"salle3",50));
            salleRepository.save(new Salle(null,"salle4",50));
            salleRepository.save(new Salle(null,"salle5",50));
            placeRepository.save(new Place(null,1));
            placeRepository.save(new Place(null,2));
            placeRepository.save(new Place(null,3));
            placeRepository.save(new Place(null,4));
            placeRepository.save(new Place(null,5));

            salleRepository.findAll().forEach(c->{
            System.out.println(c.toString());
        });
    };}

}
