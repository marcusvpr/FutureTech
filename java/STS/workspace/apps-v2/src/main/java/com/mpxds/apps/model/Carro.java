package com.mpxds.apps.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Carro {
    //
    @Id
    @GeneratedValue
    private Long id;

    private String modelo;
    private String placa;
    private String motor;

    private Date dataFabricacao;

}