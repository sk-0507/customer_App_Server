package com.example.demo.customerRepository;

 
 import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

 
	   @Query("SELECT c FROM CustomerModel c WHERE " +
	           "LOWER(c.firstName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
	           "LOWER(c.email) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
	           "LOWER(c.city) LIKE LOWER(CONCAT('%', :search, '%'))")
	    Page<CustomerModel> searchCustomers(@Param("search") String search, Pageable pageable);

	   Optional<CustomerModel> findByEmail(String uuid); 


}
