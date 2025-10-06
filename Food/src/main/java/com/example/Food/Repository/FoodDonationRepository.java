package com.example.Food.Repository;

import com.example.Food.Entity.FoodDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDonationRepository extends JpaRepository<FoodDonation, Long> {}
