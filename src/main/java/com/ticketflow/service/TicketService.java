package com.ticketflow.service;

import com.ticketflow.model.Ticket;
import com.ticketflow.repository.TicketRepository;
import org.springframework.stereotype.Service;
import com.ticketflow.exception.TicketNaoEncontradoException;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public List<Ticket> listarTodos() {
        return repository.findAll();
    }

    public Ticket buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TicketNaoEncontradoException(id));
    }
}
