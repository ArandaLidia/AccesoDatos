package com.example.APIAdoptame.repositories;

import com.example.APIAdoptame.model.Adoptante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptanteRepository extends JpaRepository<Adoptante, Integer> {

    Adoptante findByEmail(String email);
}
