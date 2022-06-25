package com.daveo.project.katabankv1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.daveo.project.katabankv1.Katabankv1Application;
import com.daveo.project.katabankv1.metier.CompteMetier;
import com.daveo.project.katabankv1.metier.OperationMetier;
import com.daveo.project.katabankv1.model.Compte;
import com.daveo.project.katabankv1.model.Operation;
import com.daveo.project.katabankv1.model.Retrait;
import com.daveo.project.katabankv1.model.Versement;

@SpringBootTest(classes = Katabankv1Application.class)
public class OperationRestServiceTest {

	@Autowired
	private OperationMetier operationMetier;
	
	@Autowired
	private CompteMetier compteMetier;
	
	
	@Test
	//@DirtiesContext
	public void addOperationVersement() {
		
		Compte cp = compteMetier.findCompteByCodeCompte("56779888333");
		Double ancienSolde = cp.getBalance();
		Operation operation = new Versement();
		operation.setDate(new Date());
		operation.setMontant(6200);
		operation.setCompte(cp);
		operation.setNumero("56779888333");
		operationMetier.versement(operation);
		
		Compte cpNew = compteMetier.findCompteByCodeCompte("56779888333");
		Double newSolde = cpNew.getBalance();

		assertNotEquals(ancienSolde,newSolde);
		
	}
@Test	
public void addOperationRetrait() {
		
		Compte cp = compteMetier.findCompteByCodeCompte("56779888333");
		Double ancienSolde = cp.getBalance();
		Operation operation = new Retrait();
		operation.setDate(new Date());
		operation.setMontant(6200);
		operation.setCompte(cp);
		operation.setNumero("56779888333");
		operationMetier.retrait(operation);
		
		Compte cpNew = compteMetier.findCompteByCodeCompte("56779888333");
		Double newSolde = cpNew.getBalance();

		assertNotEquals(ancienSolde,newSolde);
		
	}
	
	@Test
	public void getCompte() {
		Compte cpt = compteMetier.findCompteByCodeCompte("56779888883");
		
		assertEquals(67800, cpt.getBalance());
		
	}

}
