package br.com.fiap.diegopinho.hackathon.hotelman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.diegopinho.hackathon.hotelman.entities.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
