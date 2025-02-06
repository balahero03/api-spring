package com.NammaEvent.NammaEvent.controller;

import com.NammaEvent.NammaEvent.model.service_provider;
import com.NammaEvent.NammaEvent.repository.Service_ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class service_providerController {
    @Autowired
    private Service_ProviderRepository serviceProviderRepository;

    @GetMapping("/get/serviceprovider/{id}")
    public List<service_provider> GetById(@PathVariable int id){
        List<service_provider> serviceProviders = serviceProviderRepository.findAll();
        List<service_provider> serviceProvider =  serviceProviders.stream().filter(n -> n.getService_provider_id()==id).toList();
        return serviceProvider;
    }

    @PostMapping("/create/serviceprovider")
    public void CreateServiceProvideer(@RequestBody service_provider serviceProvider){
        service_provider serviceProvider1 = new service_provider();
        serviceProvider1 = serviceProvider;
        serviceProviderRepository.save(serviceProvider1);
    }

    @GetMapping("/get/serviceprovider")
    public List<service_provider> GetAllServiceProvider(){
        List<service_provider> serviceProviders = serviceProviderRepository.findAll();
        return serviceProviders;
    }

    @PutMapping("/update/serviceprovider/{id}")
    public void UpdateServiceProvider(@PathVariable int id,@RequestBody service_provider serviceProvider){
        serviceProvider.setService_provider_id(id);
        serviceProviderRepository.save(serviceProvider);
    }


}
