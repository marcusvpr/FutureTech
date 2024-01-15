package com.futuretech.apps.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futuretech.apps.domain.model.FtConta;

public interface FtContaRepository extends JpaRepository<FtConta, Integer> {
	//
}
