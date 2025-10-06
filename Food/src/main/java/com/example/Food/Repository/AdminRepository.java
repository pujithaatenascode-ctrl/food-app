package com.example.Food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Food.Entity.Admin;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}
