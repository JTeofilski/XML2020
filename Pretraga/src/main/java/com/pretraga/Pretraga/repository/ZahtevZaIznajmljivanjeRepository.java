package com.pretraga.Pretraga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pretraga.Pretraga.model.ZahtevZaIznajmljivanje;
import com.pretraga.Pretraga.repository.*;

@Repository
public interface ZahtevZaIznajmljivanjeRepository extends JpaRepository<ZahtevZaIznajmljivanje, Long> {

	ZahtevZaIznajmljivanje findByIdentifikacioniBroj(long id);
}
