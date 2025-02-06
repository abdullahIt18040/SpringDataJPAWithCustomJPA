package com.sdlcpro.sdlcprospringjpaapp.respository;

import com.sdlcpro.sdlcprospringjpaapp.entities.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems,Integer> {
}
