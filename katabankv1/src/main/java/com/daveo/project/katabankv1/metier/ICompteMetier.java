package com.daveo.project.katabankv1.metier;

import com.daveo.project.katabankv1.model.Compte;

public interface ICompteMetier {
	public Compte saveCompte(Compte compte);
	public Compte getCompte(String compteNum);
	public Compte findCompteByCodeCompte(String compteNum);
}
