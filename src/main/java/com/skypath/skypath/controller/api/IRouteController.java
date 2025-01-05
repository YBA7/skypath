package com.skypath.skypath.controller.api;

import com.skypath.skypath.response.RouteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/routes")
public interface IRouteController {
    @GetMapping(value = "/getRoutes", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<RouteResponse>> getRoutes(@RequestParam("fromLocationId") Long fromLocationId, @RequestParam("toLocationId") Long toLocationId);
}
