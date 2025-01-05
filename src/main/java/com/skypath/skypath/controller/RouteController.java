package com.skypath.skypath.controller;

import com.skypath.skypath.controller.api.IRouteController;
import com.skypath.skypath.response.RouteResponse;
import com.skypath.skypath.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RouteController implements IRouteController {
    private final RouteService routeService;

    @Override
    public ResponseEntity<List<RouteResponse>> getRoutes(Long fromLocationId, Long toLocationId) {
        List<RouteResponse> routes = routeService.calculateRoutes(fromLocationId, toLocationId);
        return ResponseEntity.ok(routes);
    }
}
