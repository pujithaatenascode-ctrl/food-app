package com.example.Food.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.Food.Entity.Admin;
import com.example.Food.Service.AdminService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @GetMapping("/getall")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }

    @PostMapping("/login")
    public Optional<Admin> login(@RequestBody Admin admin) {
        return adminService.login(admin.getEmail(), admin.getPassword());
    }
}
