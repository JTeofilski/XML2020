package com.registracija.Registracija.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registracija.Registracija.model.RegistrovaniKorisnik;

public interface RegistrovaniKorisnikRepository extends JpaRepository<RegistrovaniKorisnik, Long>{

	RegistrovaniKorisnik findByEmailAndLozinka(String email, String lozinka);
}
