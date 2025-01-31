package com.sdlcpro.sdlcprospringjpaapp.dto;

import com.sdlcpro.sdlcprospringjpaapp.entities.Address;

public record StudentNameAgeAddressDto(String name, Integer age, Address address) {
}
