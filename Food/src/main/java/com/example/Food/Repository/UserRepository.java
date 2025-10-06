package com.example.Food.Repository;

import com.example.Food.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
 
    List<User> findByRole(String role);
    Optional<User> findByEmailAndPasswordAndRole(String email, String password, String role);
}
