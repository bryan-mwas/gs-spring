package com.groupworkrmi.service;

import com.groupworkrmi.service.order.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import java.net.UnknownHostException;

@Configuration
public class RmiServiceApp {

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl();
    }

    @Bean
    public RmiServiceExporter exporter() throws UnknownHostException {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("OrderService");
        rmiServiceExporter.setService(orderService());
        rmiServiceExporter.setServiceInterface(OrderService.class);
        rmiServiceExporter.setRegistryPort(2099);
        rmiServiceExporter.setAlwaysCreateRegistry(true);
        return rmiServiceExporter;
    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(RmiServiceApp.class);
    }

}