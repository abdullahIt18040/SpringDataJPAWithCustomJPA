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
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.*;


@SpringBootApplication
public class SdlcprospringjpaAppApplication implements CommandLineRunner  {



    public static void main(String[] args) {
        SpringApplication.run(SdlcprospringjpaAppApplication.class, args);
    }
@Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private OrderItemsRepository orderItemsRepository;
    @Autowired
    private AppUserOrderRepository appUserOrderRepository;
    @Override
    public void run(String... args) throws Exception {



      var order =  appUserOrderRepository.findByIdAndUser(1,new AppUser(1));
        System.out.println(order);

        var invoice = buildInvoice(order);
sendInvoiceMailTo(invoice);



//
//        var user = new AppUser("Abdullah","abdullah@gmail.com","mohammadpur");
//        appUserRepository.save(user);
//        var order = new AppUserOrders(user,List.of(
//                new OrderItems(new Product("mango",23.5),2),
//                new OrderItems(new Product("bannana",53.36),5)
//        ));
//appUserOrderRepository.save(order);
    }

    private InvoiceInfo buildInvoice(AppUserOrders order)
    {
        var user = order.getUser();
        var invoiceItems =  order.getOrderItems().stream().map(i->
                new InvoiceDesItem(i.getProduct().getName(),
                        i.getQuantity(), i.getProduct().getPrice(),
                        i.getProduct().getPrice()* i.getQuantity() )

                ).toList();

        var total = invoiceItems.stream().map(InvoiceDesItem::amount).reduce(0.0,Double::sum);

        var context = new Context();
        context.setVariable("invoiceNumber",order.getId());
        context.setVariable("companyName",user.getName());
        context.setVariable("companyAddress",user.getAddress());
        context.setVariable("companyEmail",user.getEmail());
        context.setVariable("clientName","it22606@gmail.com");
        context.setVariable("clientAddress","dhaka");
        context.setVariable("clientEmail","tarek@gmail.com");
        context.setVariable("items",invoiceItems);
        context.setVariable("total",total);


        var content = templateEngine.process("invoice",context);

        return new InvoiceInfo(content, user.getEmail());

    }
    private void sendInvoiceMailTo(InvoiceInfo invoiceInfo)
    {try {


        var mimeMessage = mailSender.createMimeMessage();
        var helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("techmammon@gmail.com");
        helper.setTo(invoiceInfo.mailTo());
        helper.setText(invoiceInfo.content(),true);
        mailSender.send(mimeMessage);
    } catch (Exception exception)
    {
        throw  new RuntimeException("mail not send ",exception);
    }
    }

}
