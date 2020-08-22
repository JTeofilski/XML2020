package com.xml.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agent.model.MarkaVozila;


public interface MarkaRepository extends JpaRepository<MarkaVozila, Long>{
    
	  
}
