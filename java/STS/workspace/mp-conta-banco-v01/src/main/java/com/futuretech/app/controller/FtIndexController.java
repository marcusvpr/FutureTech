package com.futuretech.app.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.futuretech.app.model.FtConta;
import com.futuretech.app.service.FtContaService;

import java.util.List;

@Component
@Data
@ViewScoped
public class FtIndexController {
	//
    @Autowired
    FtContaService ftContaService;
    
    private List<FtConta> ftContas;
    
    private FtConta ftContaSelecionada;

    private static final Logger logger = LoggerFactory.getLogger(FtIndexController.class);

    // ---
    
    @PostConstruct
    public void init() {
    	//
        cargarDatos();
    }

    public void cargarDatos() {
    	//
        this.ftContas = ftContaService.listarFtContas();
        
        ftContas.forEach((ftConta) -> logger.info(ftConta.toString()));
    }

    public void agregarConta() {
    	//
        this.ftContaSelecionada = new FtConta();
    }

    public void guardarConta() {
    	//
        logger.info("Conta a guardar: " + this.ftContaSelecionada);
        
        // Agregar
        if(this.ftContaSelecionada.getId() == null) {
        	//
            this.ftContaService.guardarFtConta(this.ftContaSelecionada);

            this.ftContas.add(this.ftContaSelecionada);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conta Gravada"));
        }
        else { // Modificar (update)
        	//
            this.ftContaService.guardarFtConta(this.ftContaSelecionada);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conta Atualizada"));
        }
        
        //
        PrimeFaces.current().executeScript("PF('ventanaModalConta').hide()");
        
        // Atualizamos a tabela
        PrimeFaces.current().ajax().update("forma-contas:mensajes", "forma-contas:contas-tabla");
        
        // Reset
        this.ftContaSelecionada = null;
    }

    public void eliminarConta() {
    	//
        logger.info("Conta a eliminar: " + this.ftContaSelecionada);
        
        this.ftContaService.eliminarFtConta(this.ftContaSelecionada);
        
        // Eliminar o registro da lista de contas
        this.ftContas.remove(this.ftContaSelecionada);
        
        // Reset o objeto selecionado da tabela
        this.ftContaSelecionada = null;
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conta Eliminada"));
        
        PrimeFaces.current().ajax().update("forma-Selecionadas:mensajes", "forma-contas:contas-tabla");
    }
}
