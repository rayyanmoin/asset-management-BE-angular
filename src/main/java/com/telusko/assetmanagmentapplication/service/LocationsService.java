package com.telusko.assetmanagmentapplication.service;

import com.telusko.assetmanagmentapplication.assetObjects.Categories;
import com.telusko.assetmanagmentapplication.assetObjects.Locations;
import com.telusko.assetmanagmentapplication.dto.CategoryDropDownDTO;
import com.telusko.assetmanagmentapplication.dto.LocationAddDTO;
import com.telusko.assetmanagmentapplication.dto.LocationDropDownDTO;
import com.telusko.assetmanagmentapplication.repository.LocationsRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationsService {

    private  final LocationsRepo locationsRepo;

    public LocationsService(LocationsRepo locationsRepo) {
        this.locationsRepo = locationsRepo;
    }

    public List<Locations> getAllLocations() {

        return locationsRepo.findAll();
    }

    public String addLocation(@RequestBody LocationAddDTO locationAddDTO) {
        Locations locations = new Locations();
        locations.setLocationName(locationAddDTO.getLocationName());
        locations.setLocationCode(locationAddDTO.getLocationCode());
        locations.setLocationDescription(locationAddDTO.getLocationDescription());
        locationsRepo.save(locations);
        return "Location saved successfully!";
    }

    public List<LocationDropDownDTO> getAllLocationsForDropDown() {
        List<Locations> locations = locationsRepo.findAll();
        List<LocationDropDownDTO> locationDropDownDTOS = new ArrayList<>();
        for(Locations locations1 : locations) {
            LocationDropDownDTO locationDropDownDTO = new LocationDropDownDTO();
            locationDropDownDTO.setLocationId(locations1.getLocationId());
            locationDropDownDTO.setLocationName(locations1.getLocationName());
            locationDropDownDTOS.add(locationDropDownDTO);
        }
        return locationDropDownDTOS;
    }


    public String updateLocation(LocationAddDTO locationAddDTO) {
        Optional<Locations> locations = locationsRepo.findById(locationAddDTO.getLocationId());
        if (locations.isPresent()) {
            Locations location = locations.get();

            location.setLocationName(locationAddDTO.getLocationName());
            location.setLocationCode(locationAddDTO.getLocationCode());
            location.setLocationDescription(locationAddDTO.getLocationDescription());

            locationsRepo.save(location);
            return "Location updated successfully!";
        }
        else {
            return "Location with Id Not found";
        }
    }

}