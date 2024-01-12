package com.futuretech.apps.controller;

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

import com.futuretech.apps.domain.model.FtConta;
import com.futuretech.apps.domain.service.FtContaService;

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
        this.carregarDados();
    }

    public void carregarDados() {
    	//
        this.ftContas = ftContaService.listarFtContas();
        
        ftContas.forEach((conta) -> logger.info(conta.toString()));
    }

    public void associarConta() {
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
        
        // Oculta form
        PrimeFaces.current().executeScript("PF('formModalConta').hide()");
        
        // Atualiza a tabela
        PrimeFaces.current().ajax().update("forma-contas:msgId", "forma-contas:contas-tabela");
        
        // Reset
        this.ftContaSelecionada = null;
    }

    public void eliminarConta() {
    	//
        logger.info("Conta a eliminar: " + this.ftContaSelecionada);
        
        this.ftContaService.eliminarFtConta(this.ftContaSelecionada);
        
        // Eliminar registro  lista de contas
        this.ftContas.remove(this.ftContaSelecionada);
        
        // Reset del objeto selecionado da tabela
        this.ftContaSelecionada = null;
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conta Eliminada"));
        
        PrimeFaces.current().ajax().update("forma-contas:msgId", "forma-contas:contas-tabela");
    }

}
