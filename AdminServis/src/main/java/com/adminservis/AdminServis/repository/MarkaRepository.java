package com.adminservis.AdminServis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminservis.AdminServis.model.MarkaVozila;

public interface MarkaRepository extends JpaRepository<MarkaVozila, Long>{
    
	  
}
