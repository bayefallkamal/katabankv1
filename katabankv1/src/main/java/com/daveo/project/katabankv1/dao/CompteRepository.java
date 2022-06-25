package com.daveo.project.katabankv1.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daveo.project.katabankv1.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String>{
	 Compte findByAccountNum(String comptenum);
}
