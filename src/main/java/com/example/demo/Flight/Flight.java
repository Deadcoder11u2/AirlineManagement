package com.example.demo.Flight;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private LocalDateTime arrival;
	private LocalDateTime departure;
	@Column(nullable = false)
	private Integer capacity;
	@Column(nullable = false, length = 3)
	private String source;
	@Column(nullable = false, length = 3)
	private String destination;
	public Flight(LocalDateTime arrival, LocalDateTime departure, Integer capacity, String source, String destination) {
		super();
		this.arrival = arrival;
		this.departure = departure;
		this.capacity = capacity;
		this.source = source;
		this.destination = destination;
	}
	
}
