package com.skypath.controller;

import com.skypath.controller.api.ILocationController;
import com.skypath.dto.LocationDto;
import com.skypath.dto.request.LocationRequest;
import com.skypath.dto.response.LocationResponse;
import com.skypath.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LocationController implements ILocationController {

    private final LocationService locationService;

    @Override
    public void createLocation(LocationRequest request) {
        locationService.createLocation(request);
    }

    @Override
    public LocationResponse getLocations(int page, int size) {
        return locationService.getAllLocations(page, size);
    }

    @Override
    public LocationDto getLocationById(Long id) {
        return locationService.getLocationById(id);
    }

    @Override
    public void updateLocation(Long id, LocationDto dto) {
        locationService.updateLocation(id, dto);
    }

    @Override
    public void deleteLocation(Long id) {
        locationService.deleteLocation(id);
    }
}