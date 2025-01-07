package com.skypath.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportationDto {
    private Long id;
    private Long originId;
    private Long destinationId;
    private Integer transportationType;
    private Integer isDeleted;
    private String createdBy;
    private OffsetDateTime createDate;
    private String updatedBy;
    private OffsetDateTime updateDate;
}
