package com.skypath.mapper;


import com.skypath.dto.LocationDto;
import com.skypath.dto.request.LocationRequest;
import com.skypath.entity.Location;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationMapper {

    public Location toEntity(LocationRequest request) {
        Location location = new Location();
        location.setName(request.getName());
        location.setType(request.getType());
        location.setCreateDate(OffsetDateTime.now());
        location.setUpdateDate(OffsetDateTime.now());
        String username = getAuthenticatedUsername();
        location.setCreatedBy(username);
        location.setUpdatedBy(username);

        return location;
    }

    // Giriş yapan kullanıcının adını alır
    //todo bunu buradan kaldırıcam...
    private String getAuthenticatedUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername(); // Kullanıcı adı
        } else {
            return principal.toString(); // Eğer kullanıcı adı yoksa Principal string olarak döner
        }
    }


    public LocationDto toDto(Location location) {
        LocationDto dto = new LocationDto();
        dto.setId(location.getId());
        dto.setName(location.getName());
        dto.setType(location.getType());
        dto.setIsDeleted(location.getIsDeleted());
        dto.setCreatedBy(location.getCreatedBy());
        dto.setCreateDate(location.getCreateDate());
        dto.setUpdatedBy(location.getUpdatedBy());
        dto.setUpdateDate(location.getUpdateDate());
        return dto;
    }

    public List<LocationDto> toDtoList(List<Location> locations) {
        return locations.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDto(Location location, LocationDto dto) {
        location.setName(dto.getName());
        location.setType(dto.getType());
        location.setUpdateDate(OffsetDateTime.now());
        String username = getAuthenticatedUsername();
        location.setUpdatedBy(username);
    }

}