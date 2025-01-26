package com.NammaEvent.NammaEvent.controller;

import com.NammaEvent.NammaEvent.model.customer;
import com.NammaEvent.NammaEvent.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/get/customer/{id}")
    public List<customer> GetCustomerById(@PathVariable int id){
        List<customer> c = customerRepository.findAll();
       return c.stream().filter(customer -> customer.getCustomerId()==id).toList();
    }



    @PostMapping("/create/customer")
    public void CreateCustomer(@RequestBody customer customer1){
        customer c = new customer();
        c = customer1;
        customerRepository.save(c);
        //customerRepository.CreateCustomer(customer.getCustomerName(),customer.getCustomerPhoneNumber(),customer.getCustomerEmailId(),customer.getCustomerPassword());
    }

    @GetMapping("/get/customer")
    public List<customer> GetCustomer(){
        return customerRepository.findAll();
    }

    @PutMapping("/update/customer/{id}")
    public void UpdateCustomer(@PathVariable int id,@RequestBody customer customer){
        customer.setCustomerId(id);
        customerRepository.save(customer);
    }
}
