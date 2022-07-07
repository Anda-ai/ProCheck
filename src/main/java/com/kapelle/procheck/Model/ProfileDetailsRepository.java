package com.kapelle.procheck.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface ProfileDetailsRepository extends JpaRepository<ProfileDetailsEntity, Long> {
        ProfileDetailsEntity findByUserId(Long userId);    
        //boolean existsById(Long id); 
    }