package com.example.Food.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity

public class NGO {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String UsersNGO;
	private Integer maxCapacity;
	private Integer currentCapacity;
	private LocalDateTime lastUpdated = LocalDateTime.now();

	@OneToMany(mappedBy = "ngo", cascade = CascadeType.ALL)
	private List<FoodDonation> foods = new ArrayList<>();

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsersNGO() {
		return UsersNGO;
	}

	public void setUsersNGO(String usersNGO) {
		UsersNGO = usersNGO;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Integer getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(Integer currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public NGO(Long id, String usersNGO, Integer maxCapacity, Integer currentCapacity, LocalDateTime lastUpdated,
			List<FoodDonation> foods) {
		Id = id;
		UsersNGO = usersNGO;
		this.maxCapacity = maxCapacity;
		this.currentCapacity = currentCapacity;
		this.lastUpdated = lastUpdated;
		this.foods = foods;
	}
	public NGO() {
		
	}
	
	
	

}