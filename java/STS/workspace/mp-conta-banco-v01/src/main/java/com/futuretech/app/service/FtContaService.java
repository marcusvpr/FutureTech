package com.futuretech.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futuretech.app.model.FtConta;
import com.futuretech.app.repository.FtContaRepositorio;

import java.util.List;

@Service
public class FtContaService implements IFtContaService {
	//
    @Autowired
    private FtContaRepositorio ftContaRepositorio;

    @Override
    public List<FtConta> listarFtContas() {
    	//
        return ftContaRepositorio.findAll();
    }

    @Override
    public FtConta buscarFtContaPorId(Integer idConta) {
    	//
        FtConta ftConta = ftContaRepositorio.findById(idConta).orElse(null);
        
        return ftConta;
    }

    @Override
    public void guardarFtConta(FtConta ftConta) {
    	//
        ftContaRepositorio.save(ftConta);
    }

    @Override
    public void eliminarFtConta(FtConta ftConta) {
    	//
        ftContaRepositorio.delete(ftConta);
    }
}
