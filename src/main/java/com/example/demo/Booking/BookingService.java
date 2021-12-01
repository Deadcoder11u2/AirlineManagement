package com.example.demo.Booking;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.User.Passenger.BookingRequest;
import com.example.demo.User.Passenger.Passenger;
import com.example.demo.User.Passenger.PassengerRepository;

@Service
public class BookingService {
	@Autowired
	public BookingRepository bookingRepo;
	
	@Autowired
	public PassengerRepository passengerRepo;
	
	public String bookTicket(BookingRequest request) {
		String generatedTransactionId = UUID.randomUUID().toString();
		bookingRepo.save(new Booking(generatedTransactionId, request.getPassengers()));
		for(Passenger pass : request.getPassengers()) {
			passengerRepo.save(pass);
		}
		return "Ticket Booked Successfully here is your transaction number " + generatedTransactionId;
	}
}
