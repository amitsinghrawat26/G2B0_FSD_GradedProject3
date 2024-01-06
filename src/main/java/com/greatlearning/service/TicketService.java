package com.greatlearning.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.TicketJpaRepository;
import com.greatlearning.model.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketJpaRepository ticketJpaRepository;

	public Ticket saveOrder(Ticket ticket) {
		return this.ticketJpaRepository.save(ticket);
	}

	public Set<Ticket> fetchAllTickets() {
		return Set.copyOf(this.ticketJpaRepository.findAll());
	}

	public Ticket updateTicket(long id, Ticket ticket) {
		Ticket existingTicket = this.ticketJpaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Ticket Details"));
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setShortDesc(ticket.shortDesc);
		return this.ticketJpaRepository.save(existingTicket);
	}

	public Ticket findTicketById(long id) {
		return this.ticketJpaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Ticket Number"));
	}

	public void deleteTicketById(long id) {
		this.ticketJpaRepository.deleteById(id);
	}

}
