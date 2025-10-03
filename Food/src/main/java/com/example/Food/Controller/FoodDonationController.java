package com.example.Food.Controller;

import com.example.Food.Entity.FoodDonation;
import com.example.Food.Service.FoodDonationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
public class FoodDonationController {

    private final FoodDonationService donationService;

    public FoodDonationController(FoodDonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping
    public List<FoodDonation> getAllDonations() {
        return donationService.getAllDonations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDonation> getDonationById(@PathVariable Long id) {
        return donationService.getDonationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ new endpoint to get donations by userId
    @GetMapping("/user/{userId}")
    public List<FoodDonation> getDonationsByUser(@PathVariable Long userId) {
        return donationService.getDonationsByUser(userId);
    }

    @PostMapping
    public FoodDonation createDonation(@RequestBody FoodDonation donation) {
        return donationService.createDonation(donation);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FoodDonation> updateDonation(
            @PathVariable Long id,
            @RequestBody FoodDonation updatedDonation
    ) {
        try {
            FoodDonation updated = donationService.updateDonation(id, updatedDonation);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/claim")
    public ResponseEntity<FoodDonation> claimDonation(
            @PathVariable Long id,
            @RequestParam("partnerId") Long partnerId
    ) {
        try {
            FoodDonation updated = donationService.claimDonation(id, partnerId);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonation(@PathVariable Long id) {
        try {
            donationService.deleteDonation(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
