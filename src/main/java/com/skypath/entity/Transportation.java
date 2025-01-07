package com.skypath.entity;

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
@Table(name = "Transportation")
public class Transportation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transportation_seq")
    @SequenceGenerator(name = "transportation_seq", sequenceName = "transportation_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin_id", nullable = false)
    private Location origin;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Location destination;

    @Column(name = "transportation_type")
    private Integer transportationType;

    @Column(name = "is_deleted")
    private Integer isDeleted = 0;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "create_date")
    private OffsetDateTime createDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "update_date")
    private OffsetDateTime updateDate;
}
