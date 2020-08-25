package com.adminservis.AdminServis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminservis.AdminServis.model.Komentar;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar,Long> {
	
	Komentar findByIdentifikacioniBroj(long id);

}
