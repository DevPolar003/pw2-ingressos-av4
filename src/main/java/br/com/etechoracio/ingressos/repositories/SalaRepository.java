package br.com.etechoracio.ingressos.repositories;

import br.com.etechoracio.ingressos.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> { }
