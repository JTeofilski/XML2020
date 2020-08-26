package com.poruka.Poruka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poruka.Poruka.model.ZahtevZaIznajmljivanje;


@Repository
public interface ZahtevZaIznajmljivanjeRepository extends JpaRepository<ZahtevZaIznajmljivanje, Long> {

	ZahtevZaIznajmljivanje findByIdentifikacioniBroj(long id);
}
