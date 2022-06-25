package com.daveo.project.katabankv1.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daveo.project.katabankv1.model.Operation;

@RepositoryRestResource(path="operations")
public interface OperationRepository extends JpaRepository<Operation, Long>{
	public List<Operation> findByNumero(String codeCompte);
	
}
