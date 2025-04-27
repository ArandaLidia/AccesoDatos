package com.example.APIAdoptame.controller;

import com.example.APIAdoptame.model.Refugio;
import com.example.APIAdoptame.services.RefugioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Ref;
import java.util.List;

@RestController
@RequestMapping("/refugios")
public class RefugioController {

    @Autowired
    private RefugioService refugioService;


    @GetMapping("/listar")
    private ResponseEntity<List<Refugio>> listarRefugios(){
        List<Refugio> refugios = refugioService.listarRefugios();
        if (!refugios.isEmpty()){
            return new ResponseEntity<>(refugios, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/info/{id}")
    private ResponseEntity<Refugio> verRefugio(@PathVariable int id){
        Refugio refugio = refugioService.verRefugio(id);
        if (refugio != null){
            return new ResponseEntity<>(refugio, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping("/eliminar/{id}")
    private ResponseEntity<String> eliminarRefugio(@PathVariable int id){
        boolean eliminado = refugioService.eliminarRefugio(id);
        if (eliminado){
            return new ResponseEntity<>("Refugio eliminado correctamente", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No hay refugio con ese id", HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/guardar")
    private ResponseEntity<Refugio> agregarRefugio(@RequestBody Refugio refugio){
        Refugio guardado = refugioService.agregarRefugio(refugio);
        if (guardado!=null){
            return new ResponseEntity<>(guardado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/modificar/{id}")
    private ResponseEntity<Refugio> modificarRefugio(@PathVariable int id, @RequestBody Refugio refugio){
        Refugio modificado = refugioService.modificarRefugio(id, refugio);
        if (modificado!=null){
            return new ResponseEntity<>(modificado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
