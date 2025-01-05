package com.skypath.skypath.controller;

import com.skypath.skypath.controller.api.ILocationController;
import com.skypath.skypath.dto.LocationDto;
import com.skypath.skypath.request.LocationRequest;
import com.skypath.skypath.response.LocationResponse;
import com.skypath.skypath.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class LocationController implements ILocationController {

    private final LocationService locationService;

    @Override
    public ResponseEntity<Boolean> createLocation(@RequestBody LocationRequest request) {
        return ResponseEntity.ok(locationService.createLocation(request));
    }

    @Override
    public ResponseEntity<LocationResponse> getLocations(int page, int size) {
        return ResponseEntity.ok(locationService.getAllLocations(page,size));
    }

    @Override
    public ResponseEntity<LocationDto> getLocationById(Long id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @Override
    public ResponseEntity<Boolean> updateLocation(Long id, LocationDto dto) {
        return ResponseEntity.ok(locationService.updateLocation(id,dto));
    }

    @Override
    public ResponseEntity<Void> deleteLocation(Long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }



}