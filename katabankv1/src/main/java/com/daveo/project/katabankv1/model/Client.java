package com.daveo.project.katabankv1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

	
	/**
	 * @author Moustapha Kamal Kane
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENT_ID", updatable = false, nullable = false)
	 private Long id;
	
	@Column(name = "NOMCLIENT", unique=false, insertable=true, updatable=true, nullable=false)
	private String nomClient;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private List<Compte> comptes = new ArrayList<Compte>();
	
	public Client() {
		super();
	}

	public Client(Long id, String nomClient, List<Compte> comptes) {
		super();
		this.id = id;
		this.nomClient = nomClient;
		this.comptes = comptes;
	}

	public Client(String nomClient, List<Compte> comptes) {
		super();
		this.nomClient = nomClient;
		this.comptes = comptes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	@JsonIgnore
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comptes, id, nomClient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(comptes, other.comptes) && Objects.equals(id, other.id)
				&& Objects.equals(nomClient, other.nomClient);
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nomClient=" + nomClient + ", comptes=" + comptes + "]";
	}
	
	
	
	
}
