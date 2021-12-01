package com.example.demo.Airline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline {
	@Id
	@Column(name = "registration_no", length = 20)
	public String airline_registration_no;
	@Column(name = "airline_name", length = 20, nullable = false)
	public String airline_name;
}
