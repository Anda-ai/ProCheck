package com.kapelle.procheck.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface BusinessDetailsRepository extends JpaRepository<BusinessDetailsEntity, Long> {
        BusinessDetailsEntity findByUser(UserEntity user);    
        boolean existsByUser(UserEntity user); 
    }