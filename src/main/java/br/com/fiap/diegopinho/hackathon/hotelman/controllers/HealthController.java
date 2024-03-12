package br.com.fiap.diegopinho.hackathon.hotelman.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

  @GetMapping
  public String status() {
    return "I'm alive!";
  }

}
