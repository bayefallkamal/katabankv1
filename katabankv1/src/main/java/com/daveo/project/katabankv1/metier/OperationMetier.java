package com.daveo.project.katabankv1.metier;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daveo.project.katabankv1.dao.CompteRepository;
import com.daveo.project.katabankv1.dao.OperationRepository;
import com.daveo.project.katabankv1.model.Compte;
import com.daveo.project.katabankv1.model.Operation;
import com.daveo.project.katabankv1.model.Retrait;
import com.daveo.project.katabankv1.model.Versement;

@Service
public class OperationMetier implements IOperationMetier {
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private CompteMetier compteMetier;
	
	public Compte versement(Operation op) {
		Compte compt  = compteMetier.findCompteByCodeCompte(op.getNumero());
		Operation operation = new Versement();
		operation.setDate(new Date());
		operation.setNumero(op.getNumero());
		operation.setMontant(op.getMontant());
		operation.setCompte(compt);
		
		compt.setBalance(compt.getBalance()+op.getMontant());
		
		compteRepository.save(compt);
		operationRepository.save(operation);
		

		
		return compt;
	}
	

	
	public Compte retrait(Operation op) {
		Compte compte  = compteMetier.findCompteByCodeCompte(op.getNumero());
		
		if (compte.getBalance()<op.getMontant()) throw new RuntimeException(" Solde du compte insufisant");
			
		Operation operation = new Retrait();
		operation.setDate(new Date());
		operation.setNumero(op.getNumero());
		operation.setMontant(op.getMontant());
		operation.setCompte(compte);
		
		compte.setBalance(compte.getBalance()-op.getMontant());
		
		compteRepository.save(compte);
		operationRepository.save(operation);
		
		
		return compte;
	}
	
	public List<Operation> getOperationByCodeCompte(String numero) {
		return operationRepository.findByNumero(numero);
	}
	
	public List<Operation> listOperations() {
		return operationRepository.findAll();
	}
	
	
	
	

}
