package com.example.demo.repositories;

import com.example.demo.models.Service_provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Service_providerRepository extends JpaRepository<Service_provider, Integer> {

}
