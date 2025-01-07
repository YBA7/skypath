package com.skypath.controller.api;


import com.skypath.dto.LocationDto;
import com.skypath.dto.request.LocationRequest;
import com.skypath.dto.response.LocationResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/location")
public interface ILocationController {
    @PostMapping(value = "/create", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    void createLocation(@RequestBody @Valid LocationRequest request);

    @GetMapping(value = "/get", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    LocationResponse getLocations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping(value = "/getById", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    LocationDto getLocationById(@RequestParam("id") Long id);

    @PutMapping(value = "/updateLocation", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateLocation(@RequestParam("id") Long id, @RequestBody LocationDto dto);

    @DeleteMapping(value = "/delete", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    void deleteLocation(@RequestParam("id") Long id);
}
