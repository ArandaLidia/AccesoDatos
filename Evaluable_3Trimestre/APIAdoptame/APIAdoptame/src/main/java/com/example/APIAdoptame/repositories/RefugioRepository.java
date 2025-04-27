package com.example.APIAdoptame.repositories;

import com.example.APIAdoptame.model.Refugio;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefugioRepository extends JpaRepository<Refugio, Integer> {
}
