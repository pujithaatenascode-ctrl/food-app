package com.example.Food.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.Food.Entity.DeliveryPartner;
import com.example.Food.Repository.DeliveryPartnerRepository;

@Service
public class DeliveryPartnerService {

    private final DeliveryPartnerRepository deliveryPartnerRepository;

    public DeliveryPartnerService(DeliveryPartnerRepository deliveryPartnerRepository) {
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }

    public List<DeliveryPartner> getAllPartners() {
        return deliveryPartnerRepository.findAll();
    }

    public DeliveryPartner getPartnerById(Long id) {
        return deliveryPartnerRepository.findById(id).orElse(null);
    }

    // ✅ New method: get by email
    public DeliveryPartner getPartnerByEmail(String email) {
        return deliveryPartnerRepository.findByEmail(email).orElse(null);
    }

    public DeliveryPartner createPartner(DeliveryPartner partner) {
        return deliveryPartnerRepository.save(partner);
    }
    
   


    public DeliveryPartner updatePartner(Long id, DeliveryPartner updatedPartner) {
        DeliveryPartner partner = getPartnerById(id);
        if (partner == null) {
            return null;
        }
        partner.setPartnerName(updatedPartner.getPartnerName());
        partner.setPhoneNumber(updatedPartner.getPhoneNumber());
        partner.setVehicleNumber(updatedPartner.getVehicleNumber());
        partner.setEmail(updatedPartner.getEmail());
        partner.setAddress(updatedPartner.getAddress());
        return deliveryPartnerRepository.save(partner);
    }

    public void deletePartner(Long id) {
        deliveryPartnerRepository.deleteById(id);
    }
}
