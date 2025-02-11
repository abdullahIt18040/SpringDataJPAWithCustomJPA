package com.sdlcpro.sdlcprospringjpaapp.services;

import com.sdlcpro.sdlcprospringjpaapp.dto.InvoiceDesItem;
import com.sdlcpro.sdlcprospringjpaapp.dto.InvoiceInfo;
import com.sdlcpro.sdlcprospringjpaapp.entities.AppUser;
import com.sdlcpro.sdlcprospringjpaapp.entities.AppUserOrders;
import com.sdlcpro.sdlcprospringjpaapp.respository.AppUserOrderRepository;
import com.sdlcpro.sdlcprospringjpaapp.respository.AppUserRepository;
import com.sdlcpro.sdlcprospringjpaapp.respository.OrderItemsRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final AppUserRepository appUserRepository;

    private final TemplateEngine templateEngine;

    private final JavaMailSender mailSender;


    private final OrderItemsRepository orderItemsRepository;

    private final AppUserOrderRepository appUserOrderRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;


    public void confirmOrder(Integer orderId,Integer userId)
    {

        CompletableFuture.supplyAsync(new Supplier<AppUserOrders>() {
                    @Override
                    public AppUserOrders get() {
                        return transactionTemplate.execute(status -> {
                            System.out.println("new set cllaed");
                            var order = appUserOrderRepository.findByIdAndUser(1,new AppUser(1));
                            Hibernate.initialize(order.getOrderItems());
                            return  order;
                        });
                    }
                })
                .thenApply(this::buildInvoice)
                .thenAccept(this::sendInvoiceMailTo)
                .exceptionally(ex->{
                    ex.printStackTrace();
                    return  null;
                });


//
//        var order =  appUserOrderRepository.findByIdAndUser(orderId,new AppUser(userId)).thenApply(orders -> buildInvoice(orders))
//                .thenAccept(invoiceInfo -> sendInvoiceMailTo(invoiceInfo))
//                .exceptionally(ex->{
//                    ex.printStackTrace();
//                    return null;
//                }) ;
//        System.out.println(order);

//        var invoice = buildInvoice(order);

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
