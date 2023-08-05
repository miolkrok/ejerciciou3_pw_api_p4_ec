package com.example.ejerciciou3_pw_api_p4_ec.repository;

import java.util.List;

import com.example.ejerciciou3_pw_api_p4_ec.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
    public List<Vehiculo> buscarTodos();
    public Vehiculo consultarPorPlaca(String placa);
}
