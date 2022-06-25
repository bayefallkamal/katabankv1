package com.daveo.project.katabankv1.metier;

import java.util.List;

import com.daveo.project.katabankv1.model.Client;

public interface IClientMetier {
	public Client saveClient(Client client);
	public List<Client> listClient();

}
