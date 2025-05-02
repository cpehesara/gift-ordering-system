package com.example.demo.repository;

import com.example.demo.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ToyRepository extends JpaRepository<Toy, String> {
    @Query(value = "SELECT * FROM Toy WHERE toyid = ?1", nativeQuery = true)
    Toy getToyByID(String toyid);
}
