package com.bryansiegel.ccsddirectories.controllers.api;

import com.bryansiegel.ccsddirectories.models.SchoolTelephoneDirectory;
import com.bryansiegel.ccsddirectories.repositories.SchoolTelephoneDirectoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school-directories")
public class SchoolTelephoneDirectoryApiController {

    private final SchoolTelephoneDirectoryRepository repository;

    public SchoolTelephoneDirectoryApiController(SchoolTelephoneDirectoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SchoolTelephoneDirectory> getAllDirectories() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public SchoolTelephoneDirectory getDirectoryById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid directory ID: " + id));
    }

    @PostMapping
    public SchoolTelephoneDirectory createDirectory(@RequestBody SchoolTelephoneDirectory directory) {
        return repository.save(directory);
    }

    @PutMapping("/{id}")
    public SchoolTelephoneDirectory updateDirectory(@PathVariable Long id, @RequestBody SchoolTelephoneDirectory directory) {
        directory.setId(id);
        return repository.save(directory);
    }

    @DeleteMapping("/{id}")
    public void deleteDirectory(@PathVariable Long id) {
        repository.deleteById(id);
    }
}