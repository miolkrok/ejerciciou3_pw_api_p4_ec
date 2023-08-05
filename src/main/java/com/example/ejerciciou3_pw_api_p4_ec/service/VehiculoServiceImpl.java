package com.example.ejerciciou3_pw_api_p4_ec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejerciciou3_pw_api_p4_ec.repository.IVehiculoRepository;
import com.example.ejerciciou3_pw_api_p4_ec.repository.modelo.Vehiculo;
import com.example.ejerciciou3_pw_api_p4_ec.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepository vehiculoRepo;

    @Override
    public List<VehiculoTO> buscarTodos() {
        List<Vehiculo> vehi = this.vehiculoRepo.buscarTodos();
        List<VehiculoTO> vehiTO= vehi.stream().map(v -> this.convertir(v)).collect(Collectors.toList());
        return vehiTO;
    }

    @Override
    public Vehiculo consultarPorPlaca(String placa) {
        return this.vehiculoRepo.consultarPorPlaca(placa);
    }

    private VehiculoTO convertir(Vehiculo vehiculo){
        VehiculoTO vehiTO= new VehiculoTO();
        vehiTO.setId(vehiculo.getId());
        vehiTO.setPlaca(vehiculo.getPlaca());
        vehiTO.setMarca(vehiculo.getMarca());
        vehiTO.setModelo(vehiculo.getModelo());
        vehiTO.setMotor(vehiculo.getMotor());
        return vehiTO;
    }
    
}
