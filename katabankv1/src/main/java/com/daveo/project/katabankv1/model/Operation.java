package com.daveo.project.katabankv1.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OPERATION",length=1)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="TYPE_OPERATION")
@JsonSubTypes({
	@Type(name="V",value=Versement.class),
	@Type(name="R",value=Retrait.class),
})

public class Operation implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String numero;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OPERATION_ID", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "DATEOPEARATION", unique=false, insertable=true, updatable=true, nullable=true)
	private Date date;
	
	@Column(name = "MONTANT", unique=false, insertable=true, updatable=true, nullable=false)
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="COMPTE_ID")
	private Compte compte;
	
	public Operation() {
		super();
	}

	public Operation(Long id, Date date, double montant, Compte compte) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.compte = compte;
	}

	public Operation(Date date, double montant, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.compte = compte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@JsonIgnore
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(compte, date, id, montant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operation other = (Operation) obj;
		return Objects.equals(compte, other.compte) && Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(montant) == Double.doubleToLongBits(other.montant);
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", compte=" + compte + "]";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
