package com.shop.client;

import com.shop.api.swagger.models.PaidProductsMessage;
import com.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentServiceReceiver {

    private ProductService productService;

    @Autowired
    public PaymentServiceReceiver(ProductService productService) {
        this.productService = productService;
    }

    @RabbitListener(queues = {"${rabbitmq.payment.queue}"})
    public void receiveMessage(PaidProductsMessage message) {
        log.info("Received message from queue payment queue {}.", message);
        productService.decreaseProductAmount(message.getProducts());
    }
}