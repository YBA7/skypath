package com.skypath.dto.response;

import com.skypath.dto.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {
    private List<LocationDto> locationDtoList;
    private long totalElements;
    private int totalPages;
}
