package com.skypath.skypath.service;


import com.skypath.skypath.dto.LocationDto;
import com.skypath.skypath.request.LocationRequest;
import com.skypath.skypath.response.LocationResponse;


public interface LocationService {
    Boolean createLocation(LocationRequest request);
    LocationResponse getAllLocations(int page, int size);
    LocationDto getLocationById(Long id);
    Boolean updateLocation(Long id, LocationDto dto);
    void deleteLocation(Long id);
}
