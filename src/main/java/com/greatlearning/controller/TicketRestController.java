package com.greatlearning.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.model.Ticket;
import com.greatlearning.service.TicketService;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketRestController {
	
	@Autowired(required=true)
	private TicketService ticketService;
	
	@PostMapping("/ticket/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket saveTicket(@RequestBody Ticket ticket) {
		return this.ticketService.saveOrder(ticket);
	}
	
	@GetMapping
	public Set<Ticket> fetchAll(){
		return this.ticketService.fetchAllTickets();
	}
	
	@GetMapping("/{id}")
	public Ticket findTicketById(@PathVariable("id")long id) {
		return this.ticketService.findTicketById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(long id) {
		this.ticketService.deleteTicketById(id);
	}
	
}
