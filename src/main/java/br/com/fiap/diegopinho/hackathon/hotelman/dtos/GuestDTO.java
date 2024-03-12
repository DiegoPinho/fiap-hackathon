package br.com.fiap.diegopinho.hackathon.hotelman.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.fiap.diegopinho.hackathon.hotelman.entities.Guest;
import jakarta.validation.constraints.NotBlank;

public class GuestDTO {

  @JsonProperty
  @NotBlank(message = "country is required and cannot be blank")
  private String country;

  @JsonProperty
  @NotBlank(message = "cpf is required and cannot be blank")
  private String cpf;

  @JsonProperty
  @NotBlank(message = "passport is required and cannot be blank")
  private String passport;

  @JsonProperty
  @NotBlank(message = "fullname is required and cannot be blank")
  private String fullName;

  @JsonProperty
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate birth;

  @JsonProperty
  @NotBlank(message = "address is required and cannot be blank")
  private String address;

  @JsonProperty
  @NotBlank(message = "phone is required and cannot be blank")
  private String phone;

  @JsonProperty
  @NotBlank(message = "email is required and cannot be blank")
  private String email;

  public Guest toEntity() {
    return new Guest(
        null, this.country, this.cpf, this.passport, this.fullName, this.birth, this.address, this.phone, this.email);
  }
}
