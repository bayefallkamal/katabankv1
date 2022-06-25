package com.daveo.project.katabankv1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daveo.project.katabankv1.metier.OperationMetier;
import com.daveo.project.katabankv1.model.Compte;
import com.daveo.project.katabankv1.model.Operation;

@RestController
//@RequestMapping("/operations")
public class OperationRestService {

	@Autowired
	private OperationMetier operationMetier;

	@PutMapping(value = "/comptes/versement")
	@Transactional
	public Compte versement(@RequestBody Operation operation) {
		System.out.println(operationMetier);
		return operationMetier.versement(operation);
	}

	@PutMapping(value = "/comptes/retrait")
	@Transactional
	public Compte retrait(@RequestBody Operation operation) {
		return operationMetier.retrait(operation);
	}

	@GetMapping(value = "/operations/{code}")
	public List<Operation> getOperationsCompte(@PathVariable String code) {
		return operationMetier.getOperationByCodeCompte(code);
	}

	@GetMapping(value = "/operations")
	public List<Operation> listOperation() {
		return operationMetier.listOperations();
	}

}
