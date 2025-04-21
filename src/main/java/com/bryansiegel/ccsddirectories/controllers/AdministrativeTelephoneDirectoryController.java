package com.bryansiegel.ccsddirectories.controllers;

import com.bryansiegel.ccsddirectories.models.AdministrativeTelephoneDirectory;
import com.bryansiegel.ccsddirectories.repositories.AdministrativeTelephoneDirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/administrative-directories")
public class AdministrativeTelephoneDirectoryController {

    @Autowired
    private AdministrativeTelephoneDirectoryRepository repository;

    @GetMapping
    public String listDirectories(Model model) {
        List<AdministrativeTelephoneDirectory> directories = repository.findAll();
        model.addAttribute("directories", directories);
        return "admin/administrative-directories/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("directory", new AdministrativeTelephoneDirectory());
        return "admin/administrative-directories/create";
    }

    @PostMapping
    public String saveDirectory(@ModelAttribute AdministrativeTelephoneDirectory directory) {
        repository.save(directory);
        return "redirect:/admin/administrative-directories";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        AdministrativeTelephoneDirectory directory = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid directory ID: " + id));
        model.addAttribute("directory", directory);
        return "admin/administrative-directories/edit";
    }

    @PostMapping("/{id}")
    public String updateDirectory(@PathVariable Long id, @ModelAttribute AdministrativeTelephoneDirectory directory) {
        directory.setId(id);
        repository.save(directory);
        return "redirect:/admin/administrative-directories";
    }

    @GetMapping("/delete/{id}")
    public String deleteDirectory(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/admin/administrative-directories";
    }
}