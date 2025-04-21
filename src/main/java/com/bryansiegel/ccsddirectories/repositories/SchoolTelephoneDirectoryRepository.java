package com.bryansiegel.ccsddirectories.repositories;

import com.bryansiegel.ccsddirectories.models.SchoolTelephoneDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolTelephoneDirectoryRepository extends JpaRepository<SchoolTelephoneDirectory, Long> {
}
