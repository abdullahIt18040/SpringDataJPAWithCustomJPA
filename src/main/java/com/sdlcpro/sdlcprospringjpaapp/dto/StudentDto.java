package com.sdlcpro.sdlcprospringjpaapp.dto;

import com.sdlcpro.sdlcprospringjpaapp.entities.Address;

public record StudentDto(Integer id, String name, String email, Integer age, Address address) {
}
