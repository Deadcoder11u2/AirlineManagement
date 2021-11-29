package com.example.demo.Customer.Passenger;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookingRequest {
	private final LocalDateTime Departing;
	private final String source;
	private final String destination;
	private final int flight_id;
	private final List<Passenger> passengers;
}

@Getter
@Setter
@Entity
class Passenger {
	@Id
	private String AadharId;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String LastName;
	@Column(nullable = false)
	int age;
	@Enumerated(EnumType.STRING)
	AgeCategory ageCatefory;
	
	
}
