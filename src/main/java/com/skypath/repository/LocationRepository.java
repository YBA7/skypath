package com.skypath.repository;

import com.skypath.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    boolean existsByNameAndType(String name, Integer type);

    boolean existsByNameAndTypeAndIdNot(String name, Integer type, Long id);

}
