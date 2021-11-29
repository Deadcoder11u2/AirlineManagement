package com.example.demo.Booking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
	
	@Id
	private String BookingId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private SeatClass seatClass;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentMode paymentMode;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
}
