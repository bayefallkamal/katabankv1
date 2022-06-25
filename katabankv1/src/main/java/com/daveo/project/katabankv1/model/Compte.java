package com.daveo.project.katabankv1.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "COMPTE")
public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPTE_ID", updatable = false, nullable = false)
	private Long codeCompte;

	@Column(name = "ACCOUNTNUMBER", unique = true, insertable = true, updatable = true, nullable = false)
	private String accountNum;

	@Column(name = "BALANCE", unique = false, insertable = true, updatable = true, nullable = false)
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT")
	private Client client;
	
	@OneToMany(mappedBy="compte")
	private List<Operation> operations;

	public Compte() {
		super();
	}

	public Compte(Long id, String accountnum, double balance, Client client, List<Operation> operations) {
		super();
		this.codeCompte = id;
		this.accountNum = accountnum;
		this.balance = balance;
		this.client = client;
		this.operations = operations;
	}

	public Compte(String accountnum, double balance, Client client, List<Operation> operations) {
		super();
		this.accountNum = accountnum;
		this.balance = balance;
		this.client = client;
		this.operations = operations;
	}

	public Long getId() {
		return codeCompte;
	}

	public void setId(Long id) {
		this.codeCompte = id;
	}

	public String getAccountnum() {
		return accountNum;
	}

	public void setAccountnum(String accountnum) {
		this.accountNum = accountnum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNum, balance, client, codeCompte, operations);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(accountNum, other.accountNum)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(client, other.client) && Objects.equals(codeCompte, other.codeCompte)
				&& Objects.equals(operations, other.operations);
	}

	@Override
	public String toString() {
		return "Compte [id=" + codeCompte + ", accountnum=" + accountNum + ", balance=" + balance + ", client=" + client
				+ ", operations=" + operations + "]";
	}


	
}
