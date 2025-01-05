package com.skypath.skypath.response;

import com.skypath.skypath.dto.LocationDto;
import com.skypath.skypath.dto.TransportationDto;
import com.skypath.skypath.entity.Transportation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportationResponse {
    private List<TransportationDto> transportationDtoList;
    private long totalElements;
    private int totalPages;
}

