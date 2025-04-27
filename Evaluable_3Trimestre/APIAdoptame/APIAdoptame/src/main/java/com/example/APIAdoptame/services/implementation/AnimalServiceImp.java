package com.example.APIAdoptame.services.implementation;

import com.example.APIAdoptame.model.Adoptante;
import com.example.APIAdoptame.model.Animal;
import com.example.APIAdoptame.model.Refugio;
import com.example.APIAdoptame.repositories.AdoptanteRepository;
import com.example.APIAdoptame.repositories.AnimalRepository;
import com.example.APIAdoptame.repositories.RefugioRepository;
import com.example.APIAdoptame.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImp implements AnimalService {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private RefugioRepository refugioRepository;
    @Autowired
    private AdoptanteRepository adoptanteRepository;


    @Override
    public List<Animal> listarAnimales() {
        return animalRepository.findAll();
    }


    @Override
    public Animal obtenerAnimalPorId(int id) {
        return animalRepository.findById(id).orElse(null);
    }

    @Override
    public Animal guardarAnimal(Animal animal) {
        // Si no ponemos esto, crea un refugio nuevo
        Optional<Refugio> refugioDB = refugioRepository.findById(animal.getRefugio().getId());
        if (refugioDB.isPresent()) {
            animal.setRefugio(refugioDB.get());

            return animalRepository.save(animal);
        } else {
            return null;
        }
    }



    @Override
    public Animal actualizarAnimal(int id, Animal animal) {
        animal.setId(id);
        return animalRepository.save(animal);
    }

    @Override
    public boolean eliminarAnimal(int id) {
            animalRepository.deleteById(id);
            return true;
    }
    @Override
    public Adoptante obtenerAdoptantePorId(int idAdoptante) {
        return adoptanteRepository.findById(idAdoptante).orElse(null);
    }

}
