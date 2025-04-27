package com.example.APIAdoptame.controller;

import com.example.APIAdoptame.model.Adoptante;
import com.example.APIAdoptame.services.AdoptanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adoptantes")
public class AdoptanteController {

    @Autowired
    AdoptanteService adoptanteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Adoptante>>listarAdoptantes(){
        List<Adoptante> listaAdoptantes = adoptanteService.listarAdoptantes();
        if (!listaAdoptantes.isEmpty()){
            return new ResponseEntity<>(listaAdoptantes, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping ("/info/{id}")
    public ResponseEntity<Adoptante> infoAdoptante(@PathVariable int id){
        Adoptante infoAdoptante = adoptanteService.mostrarAdoptante(id);
        if (infoAdoptante != null){
            return new ResponseEntity<>(infoAdoptante  , HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Adoptante> modificarAdoptante(@PathVariable int id, @RequestBody Adoptante adoptante){
        Adoptante modificado = adoptanteService.acutalizarAdoptante(id, adoptante);
        if (modificado!=null){
            return new ResponseEntity<>(modificado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Adoptante> crearAdoptante(@RequestBody Adoptante adoptante){
        Adoptante creado = adoptanteService.crearAdoptante(adoptante);
        if (creado !=null ){
            return new ResponseEntity<>(creado, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarAdoptante(@PathVariable int id){
        Boolean eliminado = adoptanteService.eliminarAdoptante(id);
        if (eliminado){
            return new ResponseEntity<>("Eliminado correctamente", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error al eliminar, el id no existe", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/info")
    public ResponseEntity<Adoptante> mostrarPorEmail(@RequestParam String email){
        Adoptante correo = adoptanteService.findByEmail(email);
        if (correo!=null){
            return new ResponseEntity<>(correo, HttpStatus.OK);
        }else {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
