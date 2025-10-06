package com.example.Food.Service;

import com.example.Food.Entity.DeliveryPartner;
import com.example.Food.Entity.FoodDonation;
import com.example.Food.Repository.DeliveryPartnerRepository;
import com.example.Food.Repository.FoodDonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodDonationService {

    private final FoodDonationRepository donationRepository;
    private final DeliveryPartnerRepository deliveryPartnerRepository;

    public FoodDonationService(FoodDonationRepository donationRepository,
                               DeliveryPartnerRepository deliveryPartnerRepository) {
        this.donationRepository = donationRepository;
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }

    // ✅ Get all donations
    public List<FoodDonation> getAllDonations() {
        return donationRepository.findAll();
    }

    // ✅ Get donation by ID
    public Optional<FoodDonation> getDonationById(Long id) {
        return donationRepository.findById(id);
    }

    // ✅ Get donations by user ID
    public List<FoodDonation> getDonationsByUser(Long userId) {
        return donationRepository.findAll()
                .stream()
                .filter(d -> d.getUser() != null && d.getUser().getId().equals(userId))
                .toList();
    }

    // ✅ Create donation
    public FoodDonation createDonation(FoodDonation donation) {
        if (donation.getStatus() == null) {
            donation.setStatus("listed"); // default
        }
        return donationRepository.save(donation);
    }

    // ✅ Update donation (status, ngo, deliveryPartner, location)
    public FoodDonation updateDonation(Long id, FoodDonation updatedDonation) {
        return donationRepository.findById(id).map(existing -> {
            if (updatedDonation.getStatus() != null) {
                existing.setStatus(updatedDonation.getStatus());
            }
            if (updatedDonation.getNgo() != null) {
                existing.setNgo(updatedDonation.getNgo());
            }
            if (updatedDonation.getDeliveryPartner() != null) {
                existing.setDeliveryPartner(updatedDonation.getDeliveryPartner());
            }
            if (updatedDonation.getLocation() != null) {
                existing.setLocation(updatedDonation.getLocation());
            }
            return donationRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Donation not found with id " + id));
    }

    // ✅ Claim donation by delivery partner
    public FoodDonation claimDonation(Long donationId, Long partnerId) {
        return donationRepository.findById(donationId).map(donation -> {
            DeliveryPartner partner = deliveryPartnerRepository.findById(partnerId)
                    .orElseThrow(() -> new RuntimeException("Delivery partner not found"));
            donation.setStatus("assigned");
            donation.setDeliveryPartner(partner);
            return donationRepository.save(donation);
        }).orElseThrow(() -> new RuntimeException("Donation not found with id " + donationId));
    }

    // ✅ Delete donation
    public void deleteDonation(Long id) {
        if (!donationRepository.existsById(id)) {
            throw new RuntimeException("Donation not found with id " + id);
        }
        donationRepository.deleteById(id);
    }
}
