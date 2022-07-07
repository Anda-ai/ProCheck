package com.kapelle.procheck.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface BusinessDetailsRepository extends JpaRepository<BusinessDetailsEntity, Long> {
        BusinessDetailsEntity findByUserId(Long userId);    
        boolean existsByUserId(Long userId); 
    }