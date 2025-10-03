package com.example.Food.Controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Food.Entity.DeliveryPartner;
import com.example.Food.Service.DeliveryPartnerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/delivery-partners")
public class DeliveryPartnerController {

    private final DeliveryPartnerService deliveryPartnerService;

    public DeliveryPartnerController(DeliveryPartnerService deliveryPartnerService) {
        this.deliveryPartnerService = deliveryPartnerService;
    }

    @GetMapping
    public List<DeliveryPartner> getAllPartners() {
        return deliveryPartnerService.getAllPartners();
    }

    @GetMapping("/{id}")
    public DeliveryPartner getPartnerById(@PathVariable Long id) {
        return deliveryPartnerService.getPartnerById(id);
    }

    // ✅ New endpoint: get by email
    @GetMapping("/by-email")
    public ResponseEntity<DeliveryPartner> getPartnerByEmail(@RequestParam String email) {
        DeliveryPartner partner = deliveryPartnerService.getPartnerByEmail(email);
        if (partner == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(partner);
    }

    @PostMapping
    public DeliveryPartner createPartner(@RequestBody DeliveryPartner partner) {
        return deliveryPartnerService.createPartner(partner);
    }

    


    @PutMapping("/{id}")
    public DeliveryPartner updatePartner(@PathVariable Long id, @RequestBody DeliveryPartner updatedPartner) {
        return deliveryPartnerService.updatePartner(id, updatedPartner);
    }

    @DeleteMapping("/{id}")
    public String deletePartner(@PathVariable Long id) {
        deliveryPartnerService.deletePartner(id);
        return ("Delivery Partner deleted successfully with id " + id);
    }
}
