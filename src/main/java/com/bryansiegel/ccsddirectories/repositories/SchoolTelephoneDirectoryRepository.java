package com.bryansiegel.ccsddirectories.repositories;

import com.bryansiegel.ccsddirectories.models.SchoolTelephoneDirectory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolTelephoneDirectoryRepository extends JpaRepository<SchoolTelephoneDirectory, Long> {
}
