package com.example.demo.dataAccess.abstracts;

import com.example.demo.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
