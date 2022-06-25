package com.daveo.project.katabankv1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.daveo.project.katabankv1.Katabankv1Application;
import com.daveo.project.katabankv1.metier.ClientMetier;
import com.daveo.project.katabankv1.metier.CompteMetier;
import com.daveo.project.katabankv1.model.Client;
import com.daveo.project.katabankv1.model.Compte;

@SpringBootTest(classes = Katabankv1Application.class)
public class CompteRestServiceTest {

	@Autowired
	private CompteMetier compteMetier;
	
	@Autowired
	private ClientMetier clientMetier;
	
	@Test
	public void addCompte() {
		Optional<Client> client = clientMetier.findClientById(1L);
		
		Compte compte = new Compte("56779888333",67800.0,client.get(),null);
		compteMetier.saveCompte(compte);
		
		Compte cp = compteMetier.findCompteByCodeCompte("56779888333");

		assertNotNull(cp);
		
	}
	
	@Test
	public void getCompte() {
		Compte cpt = compteMetier.findCompteByCodeCompte("56779888883");
		
		assertEquals(67800, cpt.getBalance());
		
	}

}
