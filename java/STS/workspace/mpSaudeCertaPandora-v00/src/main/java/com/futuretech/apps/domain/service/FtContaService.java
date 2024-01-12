package com.futuretech.apps.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futuretech.apps.domaim.repository.FtContaRepository;
import com.futuretech.apps.domain.model.FtConta;

import java.util.List;

@Service
public class FtContaService implements IFtContaService{
	//
    @Autowired
    private FtContaRepository ftContaRepository;

    @Override
    public List<FtConta> listarFtContas() {
    	//
        return ftContaRepository.findAll();
    }

    @Override
    public FtConta buscarFtContaPorId(Integer id) {
    	//
        FtConta ftConta = ftContaRepository.findById(id).orElse(null);

        return ftConta;
    }

    @Override
    public void guardarFtConta(FtConta ftConta) {
    	//
        ftContaRepository.save(ftConta);
    }

    @Override
    public void eliminarFtConta(FtConta ftConta) {
    	//
        ftContaRepository.delete(ftConta);
    }

}
