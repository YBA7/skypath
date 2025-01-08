package com.skypath.mapper;

import com.skypath.dto.LocationDto;
import com.skypath.dto.request.LocationRequest;
import com.skypath.entity.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.OffsetDateTime;
import java.util.List;

@Mapper(componentModel = "spring", imports = OffsetDateTime.class)
public interface LocationMapper {

    @Mapping(target = "createDate", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "updateDate", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "createdBy", expression = "java(getAuthenticatedUsername())")
    @Mapping(target = "updatedBy", expression = "java(getAuthenticatedUsername())")
    Location toEntity(LocationRequest request);

    LocationDto toDto(Location location);

    List<LocationDto> toDtoList(List<Location> locations);

    @Mapping(target = "updateDate", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "updatedBy", expression = "java(getAuthenticatedUsername())")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(LocationDto dto, @MappingTarget Location location);

    default String getAuthenticatedUsername() {
        Object principal = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            return ((org.springframework.security.core.userdetails.UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}
