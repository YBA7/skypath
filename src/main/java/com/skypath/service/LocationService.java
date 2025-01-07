package com.skypath.service;


import com.skypath.dto.LocationDto;
import com.skypath.dto.request.LocationRequest;
import com.skypath.dto.response.LocationResponse;


public interface LocationService {
    void createLocation(LocationRequest request);

    LocationResponse getAllLocations(int page, int size);

    LocationDto getLocationById(Long id);

    void updateLocation(Long id, LocationDto dto);

    void deleteLocation(Long id);
}
