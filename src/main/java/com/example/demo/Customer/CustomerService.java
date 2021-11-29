package com.example.demo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return customerRepository.findByEmail(username);
	}

	public String register(RegistrationRequest customer) {
		Customer cust = customerRepository.findByEmail(customer.getEmail());
		if (cust != null) {
			return "Email already registered";
		}
		BCryptPasswordEncoder passwordencoder = new BCryptPasswordEncoder();
		String password = passwordencoder.encode(customer.getPassword());
		customerRepository
				.save(new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmail(), password));
		return "User Successfully Register";
	}
}
