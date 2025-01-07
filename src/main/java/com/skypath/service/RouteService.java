package com.skypath.service;

import com.skypath.dto.response.RouteResponse;

import java.util.List;

public interface RouteService {
    List<RouteResponse> findRoutes(Long fromLocationId, Long toLocationId);
}
