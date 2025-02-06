package com.sdlcpro.sdlcprospringjpaapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private Integer quantity;
    @ManyToOne
    private AppUserOrders orders;

    public OrderItems(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
