package com.example.demo.repositories;


import com.example.demo.models.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {
    Operator findOperatorByName(String name);
}
