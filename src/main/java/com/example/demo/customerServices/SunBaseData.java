package com.example.demo.customerServices;

 import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.customerRepository.CustomerRepository;
import com.example.demo.dtos.SunBaseResponse;
import com.example.demo.model.CustomerModel;


@Service
public class SunBaseData {
	
	private static String token = "dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=";
	private static String API = "https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list";
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	private final CustomerRepository customerRepository;
	
	  @Autowired
	    public SunBaseData(CustomerRepository customerRepository) {
	        this.customerRepository = customerRepository;
	    }
	  
	public Optional<CustomerModel> getUuid(String uuid) {
		return customerRepository.findByUuid(uuid);
	}
	
	
	
	public List<CustomerModel> getUserList() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Authorization", "Bearer " + token);
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> entity = new HttpEntity<>(headers);

	    try {
	        ResponseEntity<List<CustomerModel>> response = restTemplate.exchange(
	            API,
	            HttpMethod.GET,
	            entity,
	            new ParameterizedTypeReference<List<CustomerModel>>() {}
	        );

	        if (response.getStatusCode().is2xxSuccessful()) {
	            List<CustomerModel> customers = response.getBody();
	            if (customers != null) {
	                for (CustomerModel customer : customers) {
	                    Optional<CustomerModel> existingCustomer = customerRepository.findByUuid(customer.getUuid());
	                    if (existingCustomer.isEmpty()) {
	                        customerRepository.save(customer);
	                    }
	                }
	            }
	            return customers;
	        } else {
	            System.out.println("Response status code: " + response.getStatusCode());
	            return Collections.emptyList();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList();
	    }
	}




	 



//	private CustomerModel customerConverted(SunBaseResponse data1) {
//		// TODO Auto-generated method stub
//		CustomerModel cust = new CustomerModel();
//		cust.setFirstName(data1.getFirstName());
//		cust.setLastName(data1.getLastName());
//		cust.setEmail(data1.getEmail());
//		cust.setAddress(data1.getAddress());
//		cust.setCity(data1.getCity());
//		cust.setPhone(data1.getPhone());
//		cust.setState(data1.getState());
//		cust.setStreet(data1.getStreet());
//		return   cust;
//	}
}
