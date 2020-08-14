package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.Cenovnik;

@Repository
public interface CenovnikRepository extends JpaRepository<Cenovnik, Long>{

	Cenovnik findByIdentifikacioniBroj(Long id);
}
