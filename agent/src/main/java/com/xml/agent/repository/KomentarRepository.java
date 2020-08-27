package com.xml.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.agent.model.Komentar;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long>{

}
