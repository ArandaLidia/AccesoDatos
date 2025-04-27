package com.example.APIAdoptame.services;

import com.example.APIAdoptame.model.Adoptante;


import java.util.List;

public interface AdoptanteService {



    Adoptante findByEmail(String email);
    List<Adoptante> listarAdoptantes();
    Adoptante mostrarAdoptante(int id);
    Adoptante acutalizarAdoptante(int id, Adoptante adoptante);
    Adoptante crearAdoptante (Adoptante adoptante);
    boolean eliminarAdoptante(int id);
}
