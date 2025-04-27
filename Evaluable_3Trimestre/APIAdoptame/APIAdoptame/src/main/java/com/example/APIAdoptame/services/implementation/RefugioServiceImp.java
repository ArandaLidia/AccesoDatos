package com.example.APIAdoptame.services.implementation;

import com.example.APIAdoptame.model.Refugio;
import com.example.APIAdoptame.repositories.RefugioRepository;
import com.example.APIAdoptame.services.RefugioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefugioServiceImp implements RefugioService {
    @Autowired
    private RefugioRepository refugioRepository;


    @Override
    public List<Refugio> listarRefugios() {
        return  refugioRepository.findAll();
    }

    @Override
    public Refugio agregarRefugio(Refugio refugio) {
        return refugioRepository.save(refugio);
    }

    @Override
    public Refugio modificarRefugio(int id, Refugio refugio) {
         refugio.setId(id);
         return refugioRepository.save(refugio);
    }

    @Override
    public boolean eliminarRefugio(int id) {

        if (refugioRepository.existsById(id)){
            refugioRepository.deleteById(id);
            return true;
        }
            return false;
    }

    @Override
    public Refugio verRefugio(int id) {
        return refugioRepository.findById(id).orElse(null);
    }
}
