package com.skypath.skypath.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {
    private String name; // Location name
    private Integer type; // 1: FROM, 2: TO
}