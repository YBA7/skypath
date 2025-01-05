package com.skypath.skypath.controller.api;

import com.skypath.skypath.dto.TransportationDto;
import com.skypath.skypath.request.TransportationRequest;
import com.skypath.skypath.response.TransportationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/transportation")
public interface ITransportationController {
    @PostMapping(value = "/create", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Boolean> createTransportation(@RequestBody TransportationRequest request);

    @GetMapping(value = "/get", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<TransportationResponse> getLocations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping(value = "/getById", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<TransportationDto> getTransportaionById(@RequestParam("id") Long id);

    @PutMapping(value = "/updateTransportation", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Boolean> updateTransportation(@RequestParam("id") Long id, @RequestBody TransportationDto dto);

    @DeleteMapping(value = "/delete", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteTransportation(@RequestParam("id") Long id);
}
