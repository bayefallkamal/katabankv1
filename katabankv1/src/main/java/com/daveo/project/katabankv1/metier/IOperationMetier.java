package com.daveo.project.katabankv1.metier;

import com.daveo.project.katabankv1.model.Compte;
import com.daveo.project.katabankv1.model.Operation;

public interface IOperationMetier {
	public Compte versement(Operation op);
	public Compte retrait(Operation op);
}
