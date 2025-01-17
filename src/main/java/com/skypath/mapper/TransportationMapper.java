package com.skypath.mapper;

import com.skypath.dto.TransportationDto;
import com.skypath.dto.request.TransportationRequest;
import com.skypath.entity.Location;
import com.skypath.entity.Transportation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransportationMapper {

    public Transportation toEntity(TransportationRequest request, Location origin, Location destination) {
        Transportation transportation = new Transportation();
        transportation.setOrigin(origin);
        transportation.setDestination(destination);
        transportation.setTransportationType(request.getTransportationType());
        transportation.setCreateDate(OffsetDateTime.now());
        transportation.setUpdateDate(OffsetDateTime.now());
        String username = getAuthenticatedUsername();
        transportation.setCreatedBy(username);
        transportation.setUpdatedBy(username);
        return transportation;
    }

    private String getAuthenticatedUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }


    public TransportationDto toDto(Transportation transportation) {
        TransportationDto dto = new TransportationDto();
        dto.setId(transportation.getId());
        dto.setOriginId(transportation.getOrigin().getId());
        dto.setDestinationId(transportation.getDestination().getId());
        dto.setTransportationType(transportation.getTransportationType());
        dto.setIsDeleted(transportation.getIsDeleted());
        dto.setCreatedBy(transportation.getCreatedBy());
        dto.setCreateDate(transportation.getCreateDate());
        dto.setUpdatedBy(transportation.getUpdatedBy());
        dto.setUpdateDate(transportation.getUpdateDate());
        return dto;
    }

    public List<TransportationDto> toDtoList(List<Transportation> transportations) {
        return transportations.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDto(Transportation transportation, TransportationDto dto, Location origin, Location destination) {
        if (dto.getTransportationType() != null) {
            transportation.setTransportationType(dto.getTransportationType());
        }
        if (origin != null) {
            transportation.setOrigin(origin);
        }
        if (destination != null) {
            transportation.setDestination(destination);
        }
        transportation.setUpdateDate(OffsetDateTime.now()); // Güncelleme tarihini otomatik ata
        String username = getAuthenticatedUsername();
        transportation.setUpdatedBy(username);
    }

}
