package com.example.Food.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Food.Entity.NGO;
import com.example.Food.Repository.NGORepository;

@Service
public class NGOService {

    private final NGORepository ngoRepository;

    public NGOService(NGORepository ngoRepository) {
        this.ngoRepository = ngoRepository;
    }

    // Create new NGO
    public NGO createNGO(NGO ngo) {
        ngo.setLastUpdated(LocalDateTime.now());
        return ngoRepository.save(ngo);
    }

    // Get NGO by ID
    public NGO getNGOById(Long id) {
        Optional<NGO> ngo = ngoRepository.findById(id);
        return ngo.orElse(null);
    }

    // Get all NGOs
    public List<NGO> getAllNGOs() {
        return ngoRepository.findAll();
    }

    // Update NGO
    public NGO updateNGO(Long id, NGO updatedNGO) {
        Optional<NGO> optionalNGO = ngoRepository.findById(id);

        if (optionalNGO.isPresent()) {
            NGO ngo = optionalNGO.get();
            ngo.setUsersNGO(updatedNGO.getUsersNGO());
            ngo.setMaxCapacity(updatedNGO.getMaxCapacity());
            ngo.setCurrentCapacity(updatedNGO.getCurrentCapacity());
            ngo.setLastUpdated(LocalDateTime.now());

            return ngoRepository.save(ngo);
        } else {
            return null;
        }
    }

    // Delete NGO by ID
    public void deleteNGO(Long id) {
        ngoRepository.deleteById(id);
    }
}
