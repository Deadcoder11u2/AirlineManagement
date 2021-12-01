package com.example.demo.User.Passenger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.Booking.Booking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Passenger {

	@Id
	@Column(name = "aadhar_id", nullable = false, length = 12)
	private String aadhar;
	
	@Column(name = "firstName", nullable = false, length = 20)
	private String firstName;
	
	@Column(name = "lastName", nullable = false, length = 20)
	private String lastName;
	
	@Column(name = "age", nullable = false)
	private int age;

	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;
}
