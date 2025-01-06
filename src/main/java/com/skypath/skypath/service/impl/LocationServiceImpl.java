package com.skypath.skypath.service.impl;


import com.skypath.skypath.dto.LocationDto;
import com.skypath.skypath.entity.Location;
import com.skypath.skypath.mapper.LocationMapper;
import com.skypath.skypath.repository.LocationRepository;
import com.skypath.skypath.request.LocationRequest;
import com.skypath.skypath.response.LocationResponse;
import com.skypath.skypath.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    public Boolean createLocation(LocationRequest request) {
        if (locationRepository.existsByNameAndType(request.getName(), request.getType())) {
            throw new IllegalArgumentException("Location with the same name and type already exists.");
        }
        Location location = locationMapper.toEntity(request);
        locationRepository.save(location);
        return true;
    }


    @Override
    public LocationResponse getAllLocations(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Location> locationPage = locationRepository.findAll(pageable);
        List<LocationDto> locationDtoList = locationMapper.toDtoList(locationPage.getContent());

        return new LocationResponse(locationDtoList, locationPage.getTotalElements(), locationPage.getTotalPages());
    }


    @Override
    public LocationDto getLocationById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        return locationMapper.toDto(location);
    }

    @Override
    public Boolean updateLocation(Long id, LocationDto dto) {
        Location existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + id));
        boolean isDuplicate = locationRepository.existsByNameAndTypeAndIdNot(dto.getName(), dto.getType(), id);
        if (isDuplicate) {
            throw new RuntimeException("Location with the same name and type already exists.");
        }
        locationMapper.updateEntityFromDto(existingLocation, dto);
        locationRepository.save(existingLocation);
        return true;
    }

    public void deleteLocation(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + id));
        locationRepository.delete(location);
    }
}
