package com.skypath.skypath.service;

import com.skypath.skypath.dto.TransportationDto;
import com.skypath.skypath.request.TransportationRequest;
import com.skypath.skypath.response.TransportationResponse;

public interface TransportationService {
    Boolean createTransportation(TransportationRequest request);

    TransportationResponse getAllLocations(int page, int size);

    TransportationDto getTransportaionById(Long id);

    Boolean updateTransportation(Long id, TransportationDto dto);

    void deleteTransportation(Long id);
}
