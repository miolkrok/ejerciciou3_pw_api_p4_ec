package com.example.ejerciciou3_pw_api_p4_ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejerciciou3_pw_api_p4_ec.repository.modelo.Vehiculo;
import com.example.ejerciciou3_pw_api_p4_ec.service.IVehiculoService;
import com.example.ejerciciou3_pw_api_p4_ec.service.to.VehiculoTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping(value = "/vehiculos")
public class VehiculoControllerRestFul {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehiculoTO>> consultarTodos() {
        List<VehiculoTO> lista = this.vehiculoService.buscarTodos();

        for (VehiculoTO vehi : lista) {
            Link myLink = linkTo(methodOn(VehiculoControllerRestFul.class).consultarPorPlaca(vehi.getPlaca()))
                    .withSelfRel();
            vehi.add(myLink);
        }
        return new ResponseEntity<>(lista, null, 200);
    }

    @GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehiculo> consultarPorPlaca(@PathVariable String placa) {
        return new ResponseEntity<>(this.vehiculoService.consultarPorPlaca(placa), null, 200);
    }

}
