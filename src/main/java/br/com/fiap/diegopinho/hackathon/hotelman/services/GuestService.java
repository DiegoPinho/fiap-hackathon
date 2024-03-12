package br.com.fiap.diegopinho.hackathon.hotelman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.diegopinho.hackathon.hotelman.dtos.GuestDTO;
import br.com.fiap.diegopinho.hackathon.hotelman.entities.Guest;
import br.com.fiap.diegopinho.hackathon.hotelman.repositories.GuestRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GuestService {

  @Autowired
  private GuestRepository guestRepository;

  public List<Guest> getAll() {
    return this.guestRepository.findAll();
  }

  public Guest getById(Long id) {
    return this.guestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Guest not found!"));
  }

  public Guest create(GuestDTO dto) {
    Guest guest = dto.toEntity();
    return this.guestRepository.save(guest);
  }

  public Guest update(Long id, GuestDTO dto) {
    this.getById(id); // check

    Guest guest = dto.toEntity();
    guest.setId(id);
    return this.guestRepository.save(guest);
  }

  public void delete(Long id) {
    this.getById(id); // check
    this.guestRepository.deleteById(id);
  }

}
