package com.telusko.assetmanagmentapplication.controller;

import com.telusko.assetmanagmentapplication.assetObjects.Assets;
import com.telusko.assetmanagmentapplication.assetObjects.Locations;
import com.telusko.assetmanagmentapplication.dto.CategoryDropDownDTO;
import com.telusko.assetmanagmentapplication.dto.LocationAddDTO;
import com.telusko.assetmanagmentapplication.dto.LocationDropDownDTO;
import com.telusko.assetmanagmentapplication.service.AssetsService;
import com.telusko.assetmanagmentapplication.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class LocationsController {

    private final LocationsService locationsService;

    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @GetMapping("/locations")
    public List<Locations> getAllLocations() {

        return locationsService.getAllLocations();
    }

    @GetMapping("/locations/list")
    public List<LocationDropDownDTO> getAllLocationsForDropDown() {
        return locationsService.getAllLocationsForDropDown();
    }

    @PostMapping("/locations/add")
    public String addLocation(@RequestBody LocationAddDTO locationAddDTO) {
        return locationsService.addLocation(locationAddDTO);
    }

    @PutMapping("/locations/update")
    public String updateLocation(@RequestBody LocationAddDTO locationAddDTO) {
        return locationsService.updateLocation(locationAddDTO);
    }


}