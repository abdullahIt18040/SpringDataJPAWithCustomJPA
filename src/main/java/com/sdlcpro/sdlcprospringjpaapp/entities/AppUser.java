package com.sdlcpro.sdlcprospringjpaapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class AppUser {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String name;
    private String email;
    private  String address;

  public AppUser(Integer id) {
    this.id = id;
  }

  public AppUser(String name, String email, String address) {
    this.name = name;
    this.email = email;
    this.address = address;
  }
}
