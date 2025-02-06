package com.NammaEvent.NammaEvent.repository;

import com.NammaEvent.NammaEvent.model.service_provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Service_ProviderRepository extends JpaRepository<service_provider,Integer> {

}
