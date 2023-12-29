package com.futuretech.app.service;

import java.util.List;

import com.futuretech.app.model.FtConta;

public interface IFtContaService {
	//
    public List<FtConta> listarFtContas();

    public FtConta buscarFtContaPorId(Integer id);

    public void guardarFtConta(FtConta ftConta);

    public void eliminarFtConta(FtConta ftConta);
}
