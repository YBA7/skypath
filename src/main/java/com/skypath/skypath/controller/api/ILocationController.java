package com.skypath.skypath.controller.api;


import com.skypath.skypath.dto.LocationDto;
import com.skypath.skypath.request.LocationRequest;
import com.skypath.skypath.response.LocationResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/locaiton")
public interface ILocationController {
    @PostMapping(value = "/create", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Boolean> createLocation(@RequestBody @Valid LocationRequest request);

    @GetMapping(value = "/get", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<LocationResponse> getLocations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping(value = "/getById", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<LocationDto> getLocationById(@RequestParam("id") Long id);

    @PutMapping(value = "/updateLocation", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Boolean> updateLocation(@RequestParam("id") Long id, @RequestBody LocationDto dto);

    @DeleteMapping(value = "/delete", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteLocation(@RequestParam("id") Long id);
}
