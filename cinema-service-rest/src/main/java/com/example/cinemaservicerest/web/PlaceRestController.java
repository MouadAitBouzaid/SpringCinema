package com.example.cinemaservicerest.web;


import com.example.cinemaservicerest.entities.Place;
import com.example.cinemaservicerest.repository.PlaceRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaceRestController {
    private PlaceRepository placeRepository;
    public PlaceRestController(PlaceRepository placeRepository){
        this.placeRepository=placeRepository;
    }
    @GetMapping("/places")
    public List<Place> places(){
        return placeRepository.findAll();    }
    @GetMapping("/places/{id}")
    public Place places(@PathVariable Long id){
        return placeRepository.findById(id)
                .orElseThrow();    }
    @PostMapping("/places")
    public Place savePlace(@RequestBody Place place){
        return placeRepository.save(place);
    }
    @PutMapping("/places/{id}")
    public Place updatePlace(@PathVariable Long id,@RequestBody Place place){
        Place place1=places(id);
        if(place.getId()!=null) place1.setId(place.getId());
        if(place.getNumPlace()!=0) place1.setNumPlace(place.getNumPlace());
        return savePlace(place1);
    }
    @DeleteMapping("/places/{id}")
    public void deletePlace(@PathVariable Long id){
        placeRepository.deleteById(id);

    }
}
