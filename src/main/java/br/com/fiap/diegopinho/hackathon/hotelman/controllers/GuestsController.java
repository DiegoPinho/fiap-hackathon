package br.com.fiap.diegopinho.hackathon.hotelman.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.diegopinho.hackathon.hotelman.dtos.GuestDTO;
import br.com.fiap.diegopinho.hackathon.hotelman.entities.Guest;
import br.com.fiap.diegopinho.hackathon.hotelman.services.GuestService;
import br.com.fiap.diegopinho.hackathon.hotelman.utils.DTOValidator;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/guests")
public class GuestsController {

  @Autowired
  private GuestService guestService;

  @Autowired
  private DTOValidator validator;

  @GetMapping
  public ResponseEntity<List<Guest>> getAll() {
    List<Guest> guests = this.guestService.getAll();
    return ResponseEntity.ok().body(guests);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") Long id) {
    try {
      Guest guest = this.guestService.getById(id);
      return ResponseEntity.ok().body(guest);
    } catch (EntityNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody GuestDTO dto) {
    Map<Object, Object> violations = validator.check(dto);
    if (!violations.isEmpty()) {
      return ResponseEntity.badRequest().body(violations);
    }

    Guest guest = this.guestService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(guest);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody GuestDTO dto, @PathVariable("id") Long id) {
    try {
      Guest guest = this.guestService.update(id, dto);
      return ResponseEntity.ok().body(guest);
    } catch (EntityNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    try {
      this.guestService.delete(id);
      return ResponseEntity.noContent().build();
    } catch (EntityNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot remove resource in use.");
    }
  }

}
