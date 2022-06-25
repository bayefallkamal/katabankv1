package com.daveo.project.katabankv1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daveo.project.katabankv1.metier.CompteMetier;
import com.daveo.project.katabankv1.model.Compte;

@RestController
@RequestMapping("/comptes")
public class CompteRestService {
	@Autowired
	private CompteMetier compteMetier;
	
	@GetMapping()
	public List<Compte> listComptes() {
		return compteMetier.listComptes();
	}
	
	@PostMapping()
	public Compte saveCompte(@RequestBody Compte cp) {
		return compteMetier.saveCompte(cp);
	}

	@GetMapping(value="{code}")
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}
	

}
