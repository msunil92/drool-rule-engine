package com.learn.ruleengine.controller;

import com.learn.ruleengine.model.Customer;
import com.learn.ruleengine.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunil
 * @project drool-rule-engine
 * @created 2021/07/24 12:34 PM
 */

@RestController
public class Endpoints {

    @Autowired
    CustomerService customerService;

    @GetMapping("status")
    public String checkStatus() {
        return "OK";
    }


    @GetMapping(value = "customer" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getcustomer() {
        Customer customer = customerService.getCustomerExcel();
        System.out.println(customer);
        System.out.println(customer.getOffers());
        return customer;
    }

    @GetMapping(value = "customer_drl" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getcustomer_drl() {
        Customer customer = customerService.getCustomerDrl();
        System.out.println(customer);
        System.out.println(customer.getOffers());
        return customer;
    }

    @PostMapping(value = "customer" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer updateCustomer(@RequestBody Customer requestCustomer) {
        Customer customer = customerService.updateCustomerFromExcelRules(requestCustomer);
        System.out.println(customer);
        System.out.println(customer.getOffers());
        return customer;
    }

    @PostMapping(value = "customer_drl" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer updateCustomerWithDrool(@RequestBody Customer requestCustomer) {
        Customer customer = customerService.updateCustomerFromDrlRules(requestCustomer);
        System.out.println(customer);
        System.out.println(customer.getOffers());
        return customer;
    }
}
