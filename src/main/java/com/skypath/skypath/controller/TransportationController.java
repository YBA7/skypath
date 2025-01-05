package com.skypath.skypath.controller;

import com.skypath.skypath.controller.api.ITransportationController;
import com.skypath.skypath.dto.TransportationDto;
import com.skypath.skypath.request.TransportationRequest;
import com.skypath.skypath.response.TransportationResponse;
import com.skypath.skypath.service.TransportationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransportationController implements ITransportationController {
    private final TransportationService transportationService;

    @Override
    public ResponseEntity<Boolean> createTransportation(@RequestBody @Valid TransportationRequest request) {
        return ResponseEntity.ok(transportationService.createTransportation(request));
    }

    @Override
    public ResponseEntity<TransportationResponse> getTransportations(int page, int size) {
        return ResponseEntity.ok(transportationService.getAllTransportations(page, size));
    }

    @Override
    public ResponseEntity<TransportationDto> getTransportaionById(Long id) {
        return ResponseEntity.ok(transportationService.getTransportaionById(id));
    }

    @Override
    public ResponseEntity<Boolean> updateTransportation(Long id, TransportationDto dto) {
        return ResponseEntity.ok(transportationService.updateTransportation(id, dto));
    }

    @Override
    public ResponseEntity<Void> deleteTransportation(Long id) {
        transportationService.deleteTransportation(id);
        return ResponseEntity.noContent().build();
    }
}
