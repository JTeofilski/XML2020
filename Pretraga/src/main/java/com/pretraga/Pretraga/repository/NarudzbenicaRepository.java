package com.pretraga.Pretraga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pretraga.Pretraga.model.Narudzbenica;


public interface NarudzbenicaRepository extends JpaRepository <Narudzbenica, Long> {
	
	Narudzbenica findByIdentifikacioniBroj(Long id);
	
	List<Narudzbenica> findAllByKorpaId(Long id);
	
	

}
