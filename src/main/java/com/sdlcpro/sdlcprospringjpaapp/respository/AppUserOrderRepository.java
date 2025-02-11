package com.sdlcpro.sdlcprospringjpaapp.respository;

import com.sdlcpro.sdlcprospringjpaapp.entities.AppUser;
import com.sdlcpro.sdlcprospringjpaapp.entities.AppUserOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public interface AppUserOrderRepository extends JpaRepository<AppUserOrders,Integer> {

AppUserOrders  findByIdAndUser(Integer id, AppUser appUser);
}
