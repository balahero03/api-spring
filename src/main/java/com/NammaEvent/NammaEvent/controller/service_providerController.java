package com.NammaEvent.NammaEvent.controller;

import com.NammaEvent.NammaEvent.model.service_provider;
import com.NammaEvent.NammaEvent.repository.Service_ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class service_providerController {
    @Autowired
    private Service_ProviderRepository serviceProviderRepository;

    @GetMapping("/get/serviceprovider/{id}")
    public service_provider GetById(@PathVariable int id){
        List<service_provider> serviceProviders = serviceProviderRepository.findAll();
        service_provider serviceProvider = (service_provider) serviceProviders.stream().filter(n -> n.getService_provider_id()==id);
        return serviceProvider;
    }
}
