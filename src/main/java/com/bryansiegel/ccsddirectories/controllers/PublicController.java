package com.bryansiegel.ccsddirectories.controllers;

import com.bryansiegel.ccsddirectories.models.SchoolTelephoneDirectory;
import com.bryansiegel.ccsddirectories.repositories.SchoolTelephoneDirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PublicController {

    @Autowired
    private final SchoolTelephoneDirectoryRepository repository;

    public PublicController(SchoolTelephoneDirectoryRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/")
    public String index(Model model) {
        List<SchoolTelephoneDirectory> directories = repository.findAll();
        model.addAttribute("directories", directories);
        return "public/index";
    }
}
