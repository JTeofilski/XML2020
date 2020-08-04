package com.pretraga.Pretraga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pretraga.Pretraga.model.Korpa;

@Repository
public interface KorpaRepository extends JpaRepository <Korpa, Long> {
	
	Korpa findByIdentifikacioniBroj(Long id);

}
