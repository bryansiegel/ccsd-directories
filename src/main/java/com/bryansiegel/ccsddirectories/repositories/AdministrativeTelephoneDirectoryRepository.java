package com.bryansiegel.ccsddirectories.repositories;

import com.bryansiegel.ccsddirectories.models.AdministrativeTelephoneDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativeTelephoneDirectoryRepository extends JpaRepository<AdministrativeTelephoneDirectory, Long> {
}
