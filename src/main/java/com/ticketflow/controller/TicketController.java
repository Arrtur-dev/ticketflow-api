package com.ticketflow.controller;

import com.ticketflow.exception.TicketNaoEncontradoException;
import com.ticketflow.model.Ticket;
import com.ticketflow.repository.TicketRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    // Injecao de dependencia: o Spring cria o TicketRepository pra gente
    // e "encaixa" ele aqui pelo construtor. Nao usamos "new TicketRepository()".
    private final TicketRepository repository;

    public TicketController(TicketRepository repository) {
        this.repository = repository;
    }

    // GET /tickets -> lista todos os chamados
    @GetMapping
    public List<Ticket> listarTodos() {
        return repository.findAll();
    }

    // GET /tickets/{id} -> busca um chamado especifico
    @GetMapping("/{id}")
    public Ticket buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TicketNaoEncontradoException(id));
    }

    // POST /tickets -> cria um novo chamado
    // @RequestBody converte o JSON enviado na requisicao em um objeto Ticket
    @PostMapping
    public Ticket criar(@Valid @RequestBody Ticket ticket) {
        return repository.save(ticket);
    }

    @PutMapping("/{id}")
    public Ticket atualizar(@PathVariable Long id, @RequestBody Ticket dadosAtualizados) {
        Ticket ticket = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket nao encontrado" + id));

        ticket.setStatus(dadosAtualizados.getStatus());
        ticket.setPrioridade(dadosAtualizados.getPrioridade());

        return repository.save(ticket);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }


}


