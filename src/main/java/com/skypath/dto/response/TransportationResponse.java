package com.skypath.dto.response;

import com.skypath.dto.TransportationDto;
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

