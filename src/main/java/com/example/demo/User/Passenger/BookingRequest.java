package com.example.demo.User.Passenger;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookingRequest {
	private final Long flight_id;
	private final Set<Passenger> passengers;
}
