package com.NammaEvent.NammaEvent.repository;

import com.NammaEvent.NammaEvent.model.customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CustomerRepository extends JpaRepository<customer, Integer> {

   // @Modifying
  //  @Transactional
  //  @Query( value = "INSERT INTO customer (customerid,customername,customerphonenumber,customeremailid,customerpassword) VALUES (:customerName,:customerPhoneNumber,:customerEmailId,:customerPassword)")
   // void CreateCustomer(@Param("customerName") String customername,@Param("customerPhoneNumber") BigInteger customerphonenumber,@Param("customerEmailId") String customeremailid,@Param("customerPassword") String customerpassword);
}
