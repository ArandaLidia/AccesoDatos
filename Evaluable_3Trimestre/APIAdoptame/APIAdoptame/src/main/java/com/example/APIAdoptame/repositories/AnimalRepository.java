package com.example.APIAdoptame.repositories;

import com.example.APIAdoptame.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
