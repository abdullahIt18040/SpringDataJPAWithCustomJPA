package com.sdlcpro.sdlcprospringjpaapp.controllers;

import com.sdlcpro.sdlcprospringjpaapp.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
@RequiredArgsConstructor
public class OrderController {
  private final   OrderService orderService;
    @ResponseBody
   @GetMapping(value = "/order",produces = MediaType.TEXT_HTML_VALUE)
    public String orderPage() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Order Page</title>
                </head>
                <body>
                    <a href="/order/now?order_id=2&user_id=1">Order Now</a>
                </body>
                </html>
                """;
    }
@ResponseBody
@GetMapping("/order/now")
        public String orderNow(
                @RequestParam("order_id") Integer orderId,
                @RequestParam("user_id") Integer userId
        )
        {
            try {
                orderService.confirmOrder(orderId,userId);

                return  "order confirm successfully";
            }catch (Exception ex)
            {
              return "order fail";
            }
        }


}

