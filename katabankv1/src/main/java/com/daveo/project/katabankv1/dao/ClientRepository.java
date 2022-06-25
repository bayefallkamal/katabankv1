package com.daveo.project.katabankv1.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.daveo.project.katabankv1.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
