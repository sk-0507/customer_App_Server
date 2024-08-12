package com.example.demo.customerServices;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.customerRepository.CustomerRepository;
import com.example.demo.model.CustomerModel;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
	
	//To save the customer
	public CustomerModel saveCustomer(CustomerModel customer) {
		return customerRepository.save(customer);
	}
	
	//To get numberofPages of customer
	   
	 
	 //to get all customer
	 public List<CustomerModel> getAllCustomer(){
		 
		 
		 return customerRepository.findAll();
	 }
	 
	 //get customer by id
	 public Optional<CustomerModel> getCustomerById(Long id) {
	        return customerRepository.findById(id);
	    }
	 
	 //delete customer by id
	 public  String deleteCustomer(Long id) {
	 List<CustomerModel> customers = customerRepository.findAll();
	 Iterator<CustomerModel> iterator = customers.iterator();
	 while(iterator.hasNext()) {
		 CustomerModel ids = iterator.next();
		 if(ids.getId()==id) {
			 customerRepository.deleteById(id);
			 return null;
		 }
	 }
		 
	        
	        return "Id number not found";
	    }

	public Page<CustomerModel> getCustomers(Pageable  pageable) {
		 
		 return customerRepository.findAll(pageable);
	}

	public Page<CustomerModel> searchCustomers(String search, Pageable pageable) {
		
		 return customerRepository.searchCustomers(search, pageable);
	}
	 
	
}
