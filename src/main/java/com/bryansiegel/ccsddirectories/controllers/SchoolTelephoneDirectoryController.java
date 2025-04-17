package com.bryansiegel.ccsddirectories.controllers;

import com.bryansiegel.ccsddirectories.models.SchoolTelephoneDirectory;
import com.bryansiegel.ccsddirectories.repositories.SchoolTelephoneDirectoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/school-directories")
public class SchoolTelephoneDirectoryController {

    private final SchoolTelephoneDirectoryRepository schoolTelephoneDirectoryRepository;

    public SchoolTelephoneDirectoryController(SchoolTelephoneDirectoryRepository schoolTelephoneDirectoryRepository) {
        this.schoolTelephoneDirectoryRepository = schoolTelephoneDirectoryRepository;
    }

    @GetMapping
    public String listDirectories(Model model) {
        model.addAttribute("directories", schoolTelephoneDirectoryRepository.findAll());
        return "admin/school-directories/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("directory", new SchoolTelephoneDirectory());
        return "admin/school-directories/create";
    }

    @PostMapping("/create")
    public String createDirectory(@ModelAttribute SchoolTelephoneDirectory directory) {
        schoolTelephoneDirectoryRepository.save(directory);
        return "redirect:/admin/school-directories";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        SchoolTelephoneDirectory directory = schoolTelephoneDirectoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid directory ID: " + id));
        model.addAttribute("directory", directory);
        return "admin/school-directories/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateDirectory(@PathVariable Long id, @ModelAttribute SchoolTelephoneDirectory directory) {
        directory.setId(id);
        schoolTelephoneDirectoryRepository.save(directory);
        return "redirect:/admin/school-directories";
    }

    @GetMapping("/delete/{id}")
    public String deleteDirectory(@PathVariable Long id) {
        schoolTelephoneDirectoryRepository.deleteById(id);
        return "redirect:/admin/school-directories";
    }
}