package com.sdlcpro.sdlcprospringjpaapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class AppUserOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private AppUser user;
    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderItems>orderItems;

    public AppUserOrders(AppUser user, List<OrderItems> orderItems) {
        this.user = user;
        this.orderItems = orderItems;
    }
}
