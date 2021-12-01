package com.example.demo.Airline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Flight.Flight;
import com.example.demo.Flight.FlightService;

@RestController
public class AirlineController {

	@Autowired
	FlightService flightService;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("airline");
		return modelAndView;
	}

	@GetMapping(value = "/find")
	@ResponseBody
	public List<Flight> searchFlights(@RequestParam String source, @RequestParam String destination) {
		return flightService.FindFlight(source, destination);
	}
}
