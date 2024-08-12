package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customerServices.CustomerService;
import com.example.demo.model.CustomerModel;

 
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	   private final CustomerService customerService;

	    @Autowired
	    public CustomerController(CustomerService customerService) {
	        this.customerService = customerService;
	    }
	
	@GetMapping
	public String test() {
		return "test string";
	}
	
	  @PostMapping("/public/create")
	    public CustomerModel createCustomer(@RequestBody CustomerModel customer) {
	        return customerService.saveCustomer(customer);
	    }
	  
	  @GetMapping("/private/{id}")
	    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable Long id) {
	        Optional<CustomerModel> customer = customerService.getCustomerById(id);
	        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	  
	  @PutMapping("/private/{id}")
	    public ResponseEntity<CustomerModel> updateCustomer(@PathVariable Long id, @RequestBody CustomerModel customerDetails) {
	        Optional<CustomerModel> customer = customerService.getCustomerById(id);
	        if (customer.isPresent()) {
	            CustomerModel customerToUpdate = customer.get();
	            if(customerDetails.getFirstName()!=null)customerToUpdate.setFirstName(customerDetails.getFirstName());
	             if(customerDetails.getLastName()!=null)customerToUpdate.setLastName(customerDetails.getLastName());
	            if(customerDetails.getStreet()!= null)customerToUpdate.setStreet(customerDetails.getStreet());
	            if(customerDetails.getCity()!=null)customerToUpdate.setCity(customerDetails.getCity());
	             if(customerDetails.getAddress()!=null)customerToUpdate.setAddress(customerDetails.getAddress());
	            if(customerDetails.getEmail()!=null)customerToUpdate.setEmail(customerDetails.getEmail());
	            if(customerDetails.getPhone()!=null)customerToUpdate.setPhone(customerDetails.getPhone());
	            if(customerDetails.getState()!=null)customerToUpdate.setState(customerDetails.getState());
	            
	            CustomerModel updatedCustomer = customerService.saveCustomer(customerToUpdate);
	            return ResponseEntity.ok(updatedCustomer);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	  
	  @DeleteMapping("/private/{id}")
	    public ResponseEntity<CustomerModel> deleteCustomer(@PathVariable Long id) {
		  String check = customerService.deleteCustomer(id);
		   if(check!=null) {
			   return ResponseEntity.notFound().build() ;
		   }else {
	       
	        
	        return ResponseEntity.ok().build();}
	    }
	  
	  @GetMapping("/public/getAll")
	  public ResponseEntity<List<CustomerModel>> getAllCustomers(){
		  return ResponseEntity.ok(customerService.getAllCustomer());
	  }
	  
	    @GetMapping("/private/ListOfCustomer")
	    public Page<CustomerModel> getCustomers(@RequestParam(defaultValue = "0") int page,
	                                       @RequestParam(defaultValue = "10") int size,
	                                       @RequestParam(defaultValue = "id") String sort,
	                                       @RequestParam(required = false) String search) {
	        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
	        

	        if (search != null && !search.isEmpty()) {
	            // If there's a search parameter, implement the logic to search
	            return customerService.searchCustomers(search, pageable);
	        } else {
	            // If there's no search parameter, return all customers with pagination and sorting
	            return customerService.getCustomers(pageable);
	        }
	    }
}
