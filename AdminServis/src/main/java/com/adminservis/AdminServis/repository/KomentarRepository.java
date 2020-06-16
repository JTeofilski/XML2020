package com.adminservis.AdminServis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminservis.AdminServis.model.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar,Long> {
	
	Komentar findByIdentifikacioniBroj(long id);

}
