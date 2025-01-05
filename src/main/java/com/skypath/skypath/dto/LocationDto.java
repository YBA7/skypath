package com.skypath.skypath.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private Long id;
    private String name;
    private Integer type; // 1: FROM, 2: TO
    private Integer isDeleted;
    private String createdBy;
    private OffsetDateTime createDate;
    private String updatedBy;
    private OffsetDateTime  updateDate;
}
