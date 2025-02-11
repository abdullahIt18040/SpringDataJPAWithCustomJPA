package com.sdlcpro.sdlcprospringjpaapp;

import com.sdlcpro.sdlcprospringjpaapp.dto.*;
import com.sdlcpro.sdlcprospringjpaapp.entities.*;
import com.sdlcpro.sdlcprospringjpaapp.interfaceProjection.StudentNameAgeProjection;
import com.sdlcpro.sdlcprospringjpaapp.respository.AppUserOrderRepository;
import com.sdlcpro.sdlcprospringjpaapp.respository.AppUserRepository;
import com.sdlcpro.sdlcprospringjpaapp.respository.OrderItemsRepository;
import com.sdlcpro.sdlcprospringjpaapp.respository.StudentRepo;
import com.sdlcpro.sdlcprospringjpaapp.specification.StudentSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.support.WindowIterator;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.*;
@EnableAsync

@SpringBootApplication
public class SdlcprospringjpaAppApplication implements CommandLineRunner  {



    public static void main(String[] args) {
        SpringApplication.run(SdlcprospringjpaAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {




//sendInvoiceMailTo(invoice);



//
//        var user = new AppUser("Abdullah","abdullah@gmail.com","mohammadpur");
//        appUserRepository.save(user);
//        var order = new AppUserOrders(user,List.of(
//                new OrderItems(new Product("mango",23.5),2),
//                new OrderItems(new Product("bannana",53.36),5)
//        ));
//appUserOrderRepository.save(order);
    }




}
