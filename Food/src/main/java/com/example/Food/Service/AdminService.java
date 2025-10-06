package com.example.Food.Service;

import org.springframework.stereotype.Service;
import com.example.Food.Entity.Admin;
import com.example.Food.Repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public Optional<Admin> login(String email, String password) {
        return adminRepository.findByEmail(email)
                .filter(admin -> admin.getPassword().equals(password));
    }
}
