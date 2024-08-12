package com.example.demo.customerRepository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
 
import com.example.demo.model.User;


public interface UserInterface extends CrudRepository<User, Long>{
	Optional<User> findByEmail(String email);

}
