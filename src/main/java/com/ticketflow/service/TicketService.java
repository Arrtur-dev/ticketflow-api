package com.ticketflow.service;

import com.ticketflow.model.Ticket;
import com.ticketflow.repository.TicketRepository;
import org.springframework.stereotype.Service;
import com.ticketflow.exception.TicketNaoEncontradoException;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

    public Ticket criar(Ticket ticket) {
        return repository.save(ticket);
    }

    public Ticket atualizar(Long id, Ticket dadosAtualizados) {
        Ticket ticket = buscarPorId(id); //reaproveita o metodo
        ticket.setStatus(dadosAtualizados.getStatus());
        ticket.setPrioridade(dadosAtualizados.getPrioridade());
        return repository.save(ticket);
    }

    public void deletar(Long id) {
        if ( !repository.existsById(id)) {
            throw  new TicketNaoEncontradoException(id);
        }
        repository.deleteById(id);
    }
}
