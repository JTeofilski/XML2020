package com.ocena.Ocena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocena.Ocena.model.Ocena;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena,Long> {

}
