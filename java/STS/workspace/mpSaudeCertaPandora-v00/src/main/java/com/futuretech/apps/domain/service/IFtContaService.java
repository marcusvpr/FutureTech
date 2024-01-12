package com.futuretech.apps.domain.service;

import java.util.List;

import com.futuretech.apps.domain.model.FtConta;

public interface IFtContaService {
	//
    public List<FtConta> listarFtContas();

    public FtConta buscarFtContaPorId(Integer id);

    public void guardarFtConta(FtConta ftConta);

    public void eliminarFtConta(FtConta ftConta);
}
