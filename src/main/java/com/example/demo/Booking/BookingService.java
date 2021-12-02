package com.example.demo.Booking;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Flight.Flight;
import com.example.demo.User.User;
import com.example.demo.User.Passenger.BookingRequest;
import com.example.demo.User.Passenger.Passenger;
import com.example.demo.User.Passenger.PassengerRepository;

@Service
public class BookingService {

	@Autowired
	public BookingRepository bookingRepo;

	@Autowired
	public PassengerRepository passengerRepository;

	public String bookTicket(BookingRequest request) {
		String generatedTransactionid = UUID.randomUUID().toString();
		Booking book = new Booking();
		book.setBookingId(generatedTransactionid);
		book.setFlight(new Flight(request.getFlightid()));
		book.setUser(new User(request.getUserid()));
		book.setPaymentMode(PaymentMode.DEBITCARD);
		book.setPrice(1445.00);
		bookingRepo.save(book);

		for (Passenger pass : request.getPassengers()) {
			Passenger temppass = new Passenger();
			temppass.setAadhar(pass.getAadhar());
			temppass.setAge(pass.getAge());
			temppass.setFirstName(pass.getFirstName());
			temppass.setLastName(pass.getLastName());
			temppass.setGender(pass.getGender());
			temppass.setUid(pass.getAadhar() + generatedTransactionid);
			temppass.setBooking(new Booking(generatedTransactionid));
			passengerRepository.save(temppass);
		}

		return "Transaction Successful " + generatedTransactionid;
	}
}
