package com.komentar.Komentar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komentar.Komentar.model.RegistrovaniKorisnik;


public interface RegistrovaniKorisnikRepository extends JpaRepository<RegistrovaniKorisnik, Long>{

	RegistrovaniKorisnik findByEmailAndLozinka(String email, String lozinka);
}
