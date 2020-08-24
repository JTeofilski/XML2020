package com.komentar.Komentar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.komentar.Komentar.model.Komentar;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long>{
	
	List<Komentar> findByOglasIdentifikacioniBroj(long id);

}
