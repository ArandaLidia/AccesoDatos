package com.example.APIAdoptame.controller;

import com.example.APIAdoptame.model.Adoptante;
import com.example.APIAdoptame.model.Animal;
import com.example.APIAdoptame.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animales")
public class AnimalController {
    @Autowired
    private AnimalService animalService;



    @GetMapping("/lista")
    public ResponseEntity<List<Animal>> listarAnimales(){
            List<Animal> animales = animalService.listarAnimales();

            if (!animales.isEmpty()){
                return new ResponseEntity<>(animales, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Animal> guardarAnimal(@RequestBody Animal animal){
        Animal guardado = animalService.guardarAnimal(animal);
       if(guardado != null){
           return new ResponseEntity<>(guardado, HttpStatus.CREATED);
       }else {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminaranimal(@PathVariable int id){

        boolean eliminado = animalService.eliminarAnimal(id);
        if (eliminado){
            return new ResponseEntity<>("Animal eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Animal no encontrado", HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/modificar/{id}")
    public ResponseEntity<String> modificarAnimal(@PathVariable int id, @RequestBody Animal animal) {
        Animal modificado = animalService.actualizarAnimal(id, animal);
        if (modificado != null) {
            return new ResponseEntity<>("Animal modificado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Animal no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Animal> verAnimal(@PathVariable int id){
        Animal animal = animalService.obtenerAnimalPorId(id);
        if (animal != null){
            return new ResponseEntity<>(animal, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/adoptar/{idAnimal}/{idAdoptante}")
    public ResponseEntity<String> adoptarAnimal(@PathVariable int idAnimal, @PathVariable int idAdoptante) {
        Animal animal = animalService.obtenerAnimalPorId(idAnimal);
        if (animal == null) {
            return new ResponseEntity<>("Animal no encontrado", HttpStatus.NOT_FOUND);
        }

        Adoptante adoptante = animalService.obtenerAdoptantePorId(idAdoptante);
        if (adoptante == null) {
            return new ResponseEntity<>("Adoptante no encontrado", HttpStatus.NOT_FOUND);
        }

        animal.setAdoptante(adoptante);
        animal.setEstado("Adoptado");

        animalService.actualizarAnimal(idAnimal, animal);
        return new ResponseEntity<>("Animal adoptado exitosamente", HttpStatus.OK);
    }

}
