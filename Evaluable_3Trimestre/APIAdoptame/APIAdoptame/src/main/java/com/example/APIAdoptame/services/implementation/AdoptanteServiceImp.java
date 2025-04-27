package com.example.APIAdoptame.services.implementation;

import com.example.APIAdoptame.model.Adoptante;
import com.example.APIAdoptame.repositories.AdoptanteRepository;
import com.example.APIAdoptame.services.AdoptanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdoptanteServiceImp implements AdoptanteService {

    @Autowired
    AdoptanteRepository adoptanteRepository;

    @Override
    public Adoptante findByEmail(String email) {
    return adoptanteRepository.findByEmail(email);
    }

    @Override
    public List<Adoptante> listarAdoptantes() {
        return adoptanteRepository.findAll();
    }

    @Override
    public Adoptante mostrarAdoptante(int id) {
        return adoptanteRepository.findById(id).orElse(null);
    }

    @Override
    public Adoptante acutalizarAdoptante(int id, Adoptante adoptante) {
            adoptante.setId(id);
            return adoptanteRepository.save(adoptante);
    }

    @Override
    public Adoptante crearAdoptante(Adoptante adoptante) {
        return adoptanteRepository.save(adoptante);
    }

    @Override
    public boolean eliminarAdoptante(int id) {

        if (adoptanteRepository.existsById(id)){
            adoptanteRepository.deleteById(id);
            return true;
        }else {
            return false;
        }

    }
}
