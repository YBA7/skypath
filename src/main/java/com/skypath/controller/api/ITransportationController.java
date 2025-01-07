package com.skypath.controller.api;

import com.skypath.dto.TransportationDto;
import com.skypath.dto.request.TransportationRequest;
import com.skypath.dto.response.TransportationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/transportation")
public interface ITransportationController {
    @PostMapping(value = "/create", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    void createTransportation(@RequestBody TransportationRequest request);

    @GetMapping(value = "/get", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    TransportationResponse getTransportations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping(value = "/getById", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    TransportationDto getTransportaionById(@RequestParam("id") Long id);

    @PutMapping(value = "/updateTransportation", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateTransportation(@RequestParam("id") Long id, @RequestBody TransportationDto dto);

    @DeleteMapping(value = "/delete", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    void deleteTransportation(@RequestParam("id") Long id);
}
