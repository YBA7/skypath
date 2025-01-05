package com.skypath.skypath.repository;

import com.skypath.skypath.entity.Location;
import com.skypath.skypath.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
