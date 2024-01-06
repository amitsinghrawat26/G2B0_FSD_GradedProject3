package com.greatlearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.model.Ticket;

@Repository
public interface TicketJpaRepository extends JpaRepository<Ticket, Long> {

}
