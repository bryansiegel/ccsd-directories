package com.bryansiegel.ccsddirectories.controllers;

import com.bryansiegel.ccsddirectories.models.SchoolTelephoneDirectory;
import com.bryansiegel.ccsddirectories.models.AssistantPrincipal;
import com.bryansiegel.ccsddirectories.repositories.AssistantPrincipalRepository;
import com.bryansiegel.ccsddirectories.repositories.SchoolTelephoneDirectoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/school-directories")
public class SchoolTelephoneDirectoryController {

    private final SchoolTelephoneDirectoryRepository schoolTelephoneDirectoryRepository;
    private final AssistantPrincipalRepository assistantPrincipalRepository;

    public SchoolTelephoneDirectoryController(SchoolTelephoneDirectoryRepository schoolTelephoneDirectoryRepository, AssistantPrincipalRepository assistantPrincipalRepository) {
        this.schoolTelephoneDirectoryRepository = schoolTelephoneDirectoryRepository;
        this.assistantPrincipalRepository = assistantPrincipalRepository;
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

    @GetMapping("/{id}/assistant-principals")
    public String listAssistantPrincipals(@PathVariable Long id, Model model) {
        SchoolTelephoneDirectory directory = schoolTelephoneDirectoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid directory ID: " + id));
        model.addAttribute("directory", directory);
        model.addAttribute("assistantPrincipals", directory.getAssistantPrincipals());
        return "admin/school-directories/assistant-principals/list";
    }

    @GetMapping("/{id}/assistant-principals/create")
    public String showCreateAssistantPrincipalForm(@PathVariable Long id, Model model) {
        SchoolTelephoneDirectory directory = schoolTelephoneDirectoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid directory ID: " + id));
        AssistantPrincipal assistantPrincipal = new AssistantPrincipal();
        assistantPrincipal.setSchoolTelephoneDirectory(directory);
        model.addAttribute("assistantPrincipal", assistantPrincipal);
        return "admin/school-directories/assistant-principals/create";
    }

    @Transactional
    @PostMapping("/{id}/assistant-principals/create")
    public String createAssistantPrincipal(@PathVariable Long id, @ModelAttribute AssistantPrincipal assistantPrincipal) {
        // Fetch the SchoolTelephoneDirectory by its ID
        SchoolTelephoneDirectory directory = schoolTelephoneDirectoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid SchoolTelephoneDirectory ID: " + id));

        // Associate the AssistantPrincipal with the fetched SchoolTelephoneDirectory
        assistantPrincipal.setSchoolTelephoneDirectory(directory);

        // Save the AssistantPrincipal
        assistantPrincipalRepository.save(assistantPrincipal);

        // Redirect to the list of assistant principals for the directory
        return "redirect:/admin/school-directories/" + id + "/assistant-principals";
    }
}