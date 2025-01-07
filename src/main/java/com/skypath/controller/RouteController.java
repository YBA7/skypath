package com.skypath.controller;

import com.skypath.controller.api.IRouteController;
import com.skypath.dto.response.RouteResponse;
import com.skypath.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RouteController implements IRouteController {
    private final RouteService routeService;

    @Override
    public List<RouteResponse> getRoutes(Long fromLocationId, Long toLocationId) {
        return routeService.findRoutes(fromLocationId, toLocationId);
    }
}
