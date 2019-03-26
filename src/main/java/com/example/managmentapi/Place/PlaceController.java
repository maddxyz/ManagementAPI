package com.example.managmentapi.Place;

import com.example.managmentapi.Business.BusinessRepository;
import com.example.managmentapi.Business.BusinessService;
import com.example.managmentapi.Product.Product;
import com.example.managmentapi.Product.ProductRepository;
import com.example.managmentapi.Product.ProductService;
import com.example.managmentapi.manager.ManagerRepository;
import com.example.managmentapi.manager.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class PlaceController {
    private final PlaceService placeService;
    private final PlaceRepository placeRepository;

    public PlaceController(PlaceService placeService, PlaceRepository placeRepository) {
        this.placeService = placeService;
        this.placeRepository = placeRepository;

    }

    @GetMapping("/place/{id}")
    public Place fetchPlace(@PathVariable Integer id) {
        return placeService.getPlace(id);
    }


    @PostMapping("/place")
    private Integer addPlace(@RequestBody Place place) {
        return placeService.add(place).getId();
    }

    @PostMapping("/place/{id}")
    private Integer editPlace(@RequestBody Place place, @PathVariable("id") Integer id) {
        return placeService.edit(id, place);
    }

    @DeleteMapping("/place/{id}")
    private void deletePlace(@PathVariable("id") Integer id) {
        if (placeRepository.findById(id).isPresent())
            placeService.delete(placeRepository.findById(id).get());

    }
}
