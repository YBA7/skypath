package com.skypath.skypath.response;

import com.skypath.skypath.dto.RouteStepDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteResponse {
    private List<RouteStepDto> steps;
}