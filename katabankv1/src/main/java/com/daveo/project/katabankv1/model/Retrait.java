package com.daveo.project.katabankv1.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{


	private static final long serialVersionUID = 1L;

}
