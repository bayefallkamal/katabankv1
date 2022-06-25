package com.daveo.project.katabankv1.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daveo.project.katabankv1.dao.CompteRepository;
import com.daveo.project.katabankv1.model.Compte;

@Service
public class CompteMetier implements ICompteMetier {
	@Autowired
	private CompteRepository compteRepository;
	
	public Compte saveCompte(Compte cp) {

		return compteRepository.save(cp);
	}

	public Compte getCompte(String comptNum) {

		return compteRepository.findByAccountNum(comptNum);
	}
	
	public List<Compte> listComptes() {
		return compteRepository.findAll();
	}

	public Compte findCompteByCodeCompte(String codeCompte) {
		return compteRepository.findByAccountNum(codeCompte);
	}
	

}
