package com.groupworkrmi.service;

import com.groupworkrmi.service.order.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@Configuration
public class RmiClientApp {

    @Bean
    public OrderBean orderBean() {
        return new OrderBean();
    }

    @Bean
    public RmiProxyFactoryBean exporter() throws UnknownHostException {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(OrderService.class);
        String hostAddress = Inet4Address.getLocalHost()
                                         .getHostAddress();
        rmiProxyFactoryBean.setServiceUrl(String.format("rmi://%s:2099/OrderService", hostAddress));
        return rmiProxyFactoryBean;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(RmiClientApp.class);
        OrderBean bean = context.getBean(OrderBean.class);
        bean.placeOrder();
        bean.listOrders();
    }

}