package com.daveo.project.katabankv1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daveo.project.katabankv1.metier.ClientMetier;
import com.daveo.project.katabankv1.model.Client;

@RestController
@RequestMapping("/clients")
public class ClientRestService {
	@Autowired
	private ClientMetier clientMetier;

	@PostMapping()
	public Client saveClient(@RequestBody Client client) {
		return clientMetier.saveClient(client);
	}
	@GetMapping()
	public List<Client> listClient() {
		return clientMetier.listClient();
	}
	
	
}
