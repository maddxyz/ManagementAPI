package com.example.managmentapi.Place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public Place getPlace(Integer id) {
        return placeRepository.findById(id).orElse(new Place());
    }

    public List<Place> getOrders(){
        return (List<Place>) placeRepository.findAll();
    }

    public Integer edit(Integer id, Place place) {
        if (placeRepository.findById(id).isPresent()) {
            placeRepository.delete(placeRepository.findById(id).get());
            place.setId(id);
            return placeRepository.save(place).getId();
        }
        else return -1;
    }

    public Place add(Place place) {
        return placeRepository.save(place);
    }


    public void delete(Place place) {
        placeRepository.delete(place);
    }

}
