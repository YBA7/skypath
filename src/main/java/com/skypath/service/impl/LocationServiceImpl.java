package com.skypath.service.impl;


import com.skypath.dto.LocationDto;
import com.skypath.dto.request.LocationRequest;
import com.skypath.dto.response.LocationResponse;
import com.skypath.entity.Location;
import com.skypath.mapper.LocationMapper;
import com.skypath.repository.LocationRepository;
import com.skypath.service.LocationService;
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
    public void createLocation(LocationRequest request) {
        //KÜÇÜLT HEPSİNİ ÖYLE KONTROL ET
        if (locationRepository.existsByNameAndType(request.getName(), request.getType())) {
            throw new IllegalArgumentException("Location with the same name and type already exists.");
        }
        Location location = locationMapper.toEntity(request);
        locationRepository.save(location);
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
    public void updateLocation(Long id, LocationDto dto) {
        Location existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + id));
        boolean isDuplicate = locationRepository.existsByNameAndTypeAndIdNot(dto.getName(), dto.getType(), id);
        if (isDuplicate) {
            throw new RuntimeException("Location with the same name and type already exists.");
        }
        locationMapper.updateEntityFromDto(dto, existingLocation);
        locationRepository.save(existingLocation);
    }

    public void deleteLocation(Long id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
        }
        //id nin var olup olmadığını ekrana göstermemeliyiz kullanıcı teyit etmeli bunu güvenlik açıklı
    }
}
