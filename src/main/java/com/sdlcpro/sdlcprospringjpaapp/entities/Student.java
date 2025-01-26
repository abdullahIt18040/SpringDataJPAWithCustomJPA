package com.sdlcpro.sdlcprospringjpaapp.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String addressName;
    @Version
    private Long version;
    @ManyToOne
    private Address address;


}
