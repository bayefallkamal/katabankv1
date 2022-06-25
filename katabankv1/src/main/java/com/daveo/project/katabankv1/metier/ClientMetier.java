package com.daveo.project.katabankv1.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daveo.project.katabankv1.dao.ClientRepository;
import com.daveo.project.katabankv1.model.Client;

@Service
public class ClientMetier implements IClientMetier {
	@Autowired
	private ClientRepository clientRepository;
	
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	public List<Client> listClient() {
		return clientRepository.findAll();
	}
	public Optional<Client> findClientById(Long idClient) {
		return clientRepository.findById(idClient);
	}

}
