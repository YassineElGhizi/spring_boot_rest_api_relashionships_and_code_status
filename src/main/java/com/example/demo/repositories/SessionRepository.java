package com.example.demo.repositories;

import com.example.demo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    Session findSessionByStartdate(Date start_date);
}
