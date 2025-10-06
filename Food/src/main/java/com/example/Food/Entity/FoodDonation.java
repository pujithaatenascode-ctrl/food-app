package com.example.Food.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "food_donations")
public class FoodDonation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodType;
    private String quantity;  // string like "10 kg", "5 packets"
    private String location;
    private String status;
    private String donorName;

    @ManyToOne
    @JoinColumn(name = "ngo_id")
    private NGO ngo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "delivery_partner_id")
    private DeliveryPartner deliveryPartner;

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFoodType() { return foodType; }
    public void setFoodType(String foodType) { this.foodType = foodType; }

    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDonorName() { return donorName; }
    public void setDonorName(String donorName) { this.donorName = donorName; }

    public NGO getNgo() { return ngo; }
    public void setNgo(NGO ngo) { this.ngo = ngo; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public DeliveryPartner getDeliveryPartner() { return deliveryPartner; }
    public void setDeliveryPartner(DeliveryPartner deliveryPartner) { this.deliveryPartner = deliveryPartner; }
}
