package br.com.fiap.diegopinho.hackathon.hotelman.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "guests")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String country;
  private String cpf;
  private String passport;
  private String fullName;
  private LocalDate birth;
  private String address;
  private String phone;
  private String email;
}
