package com.example.demo.dataAccess.abstracts;

import com.example.demo.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
