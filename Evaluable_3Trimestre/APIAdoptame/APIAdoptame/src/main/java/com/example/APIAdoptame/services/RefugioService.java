package com.example.APIAdoptame.services;

import com.example.APIAdoptame.model.Refugio;

import java.util.List;

public interface RefugioService {

    List<Refugio> listarRefugios();
    Refugio agregarRefugio(Refugio refugio);
    Refugio modificarRefugio(int id, Refugio refugio);
    boolean eliminarRefugio (int id);
    Refugio verRefugio(int id);
}
