package com.example.APIAdoptame.services;

import com.example.APIAdoptame.model.Adoptante;
import com.example.APIAdoptame.model.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> listarAnimales();
    Animal obtenerAnimalPorId(int id);
    Animal guardarAnimal(Animal animal);
    Animal actualizarAnimal(int id, Animal animal);
    boolean eliminarAnimal(int id);
    Adoptante obtenerAdoptantePorId(int idAdoptante);

}
