package com.NammaEvent.NammaEvent.security;

import com.NammaEvent.NammaEvent.model.customer;
import com.NammaEvent.NammaEvent.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        customer customer = customerRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("UserName Not Found"));
        return new User(customer.getCustomerEmailId(),customer.getCustomerPassword(),new ArrayList<>());
    }
}
