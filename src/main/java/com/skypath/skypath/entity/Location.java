package com.skypath.skypath.entity;

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
@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
    @SequenceGenerator(name = "location_seq", sequenceName = "location_seq", allocationSize = 1)
    private Long id;

    private String name;

    private Integer type; // 1: FROM, 2: TO

    @Column(name = "is_deleted")
    private Integer isDeleted;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "create_date")
    private OffsetDateTime createDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "update_date")
    private OffsetDateTime updateDate;
}
