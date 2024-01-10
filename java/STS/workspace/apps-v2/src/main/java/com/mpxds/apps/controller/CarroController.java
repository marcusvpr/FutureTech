package com.mpxds.apps.controller;

import com.mpxds.apps.model.Carro;
import com.mpxds.apps.repository.CarroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.view.ViewScoped;
//import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// @Named
@ViewScoped
@Controller
public class CarroController implements Serializable {
	//
    private static final long serialVersionUID = 1L;

	//
    private Carro carro = new Carro();

    private List<Carro> carros = new ArrayList<>();

    @Autowired
    private CarroRepository carroRepository;

    // ---

    public void fetchAll() {
        //
        carros = carroRepository.findAll();
    }

    public void save() { 
        //
        carroRepository.save(carro);
        
        carro = new Carro();
        carros = carroRepository.findAll();
    }

    public void edit(Carro carro) {
        //
        this.carro = carro;
    }

    public void refresh() { 
        //
        carro = new Carro();
    }

    public List<Carro> getCarros() {
        //
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        //
        this.carros = carros;
    }

    public Carro getCarro() {
        //
        return carro;
    }

    public void setCarro(Carro carro) {
        //
        this.carro = carro;
    }

}