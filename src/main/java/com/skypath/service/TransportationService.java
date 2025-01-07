package com.skypath.service;

import com.skypath.dto.TransportationDto;
import com.skypath.dto.request.TransportationRequest;
import com.skypath.dto.response.TransportationResponse;

public interface TransportationService {
    void createTransportation(TransportationRequest request);

    TransportationResponse getAllTransportations(int page, int size);

    TransportationDto getTransportaionById(Long id);

    void updateTransportation(Long id, TransportationDto dto);

    void deleteTransportation(Long id);
}
