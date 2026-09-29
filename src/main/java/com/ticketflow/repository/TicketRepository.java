package com.ticketflow.repository;

import com.ticketflow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// So de estender JpaRepository, ja ganhamos de graca:
// save(), findAll(), findById(), deleteById(), e mais.
// O Spring gera a implementacao sozinho, em tempo de execucao.
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAll();
}
