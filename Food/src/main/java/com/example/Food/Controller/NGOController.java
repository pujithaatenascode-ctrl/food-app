package com.example.Food.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.example.Food.Entity.NGO;
import com.example.Food.Service.NGOService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ngos")
public class NGOController {

    private final NGOService ngoService;

    public NGOController(NGOService ngoService) {
        this.ngoService = ngoService;
    }

    // Get all NGOs
    @GetMapping
    public List<NGO> getAllNGOs() {
        return ngoService.getAllNGOs();
    }

    // Get NGO by ID
    @GetMapping("/{id}")
    public NGO getNGOById(@PathVariable Long id) {
        return ngoService.getNGOById(id);
    }

    // Create new NGO
    @PostMapping
    public NGO createNGO(@RequestBody NGO ngo) {
        return ngoService.createNGO(ngo);
    }

    // Update NGO
    @PutMapping("/{id}")
    public NGO updateNGO(@PathVariable Long id, @RequestBody NGO updatedNGO) {
        return ngoService.updateNGO(id, updatedNGO);
    }

    // Delete NGO
    @DeleteMapping("/{id}")
    public void deleteNGO(@PathVariable Long id) {
        ngoService.deleteNGO(id);
    }
}
