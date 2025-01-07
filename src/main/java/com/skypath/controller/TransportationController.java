package com.skypath.controller;

import com.skypath.controller.api.ITransportationController;
import com.skypath.dto.TransportationDto;
import com.skypath.dto.request.TransportationRequest;
import com.skypath.dto.response.TransportationResponse;
import com.skypath.service.TransportationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransportationController implements ITransportationController {
    private final TransportationService transportationService;

    @Override
    public void createTransportation(@RequestBody @Valid TransportationRequest request) {
        transportationService.createTransportation(request);
    }

    @Override
    public TransportationResponse getTransportations(int page, int size) {
        return transportationService.getAllTransportations(page, size);
    }

    @Override
    public TransportationDto getTransportaionById(Long id) {
        return transportationService.getTransportaionById(id);
    }

    @Override
    public void updateTransportation(Long id, TransportationDto dto) {
        transportationService.updateTransportation(id, dto);
    }

    @Override
    public void deleteTransportation(Long id) {
        transportationService.deleteTransportation(id);
    }
}
