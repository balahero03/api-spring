package com.NammaEvent.NammaEvent.auth;

import com.NammaEvent.NammaEvent.model.customer;
import com.NammaEvent.NammaEvent.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         List<customer> customerList = customerRepository.findAll();
         List<customer> customer = customerList.stream().filter(n -> n.getCustomerEmailId().equals(username)).toList();
        System.out.println(customer.get(0).getCustomerEmailId() + customer.get(0).getCustomerPassword());
         if(customer!=null) {
              return new User(username,customer.get(0).getCustomerPassword(),new ArrayList<>());
         }
         else{
             throw new UsernameNotFoundException("Username Not Found");
         }
    }
}
