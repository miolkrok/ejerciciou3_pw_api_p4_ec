package com.example.ejerciciou3_pw_api_p4_ec.service;

import java.util.List;

import com.example.ejerciciou3_pw_api_p4_ec.repository.modelo.Vehiculo;
import com.example.ejerciciou3_pw_api_p4_ec.service.to.VehiculoTO;

public interface IVehiculoService {

    public List<VehiculoTO> buscarTodos();

    public Vehiculo consultarPorPlaca(String placa);

}
