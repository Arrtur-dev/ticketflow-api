package com.ticketflow.controller;

import com.ticketflow.model.Ticket;
import com.ticketflow.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ticket> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Ticket buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Ticket criar(@Valid @RequestBody Ticket ticket) {
        return service.criar(ticket);
    }

    @PutMapping("/{id}")
    public Ticket atualizar(@PathVariable Long id, @RequestBody Ticket dadosAtualizados) {
        return service.atualizar(id, dadosAtualizados);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/status")
    public String status() {
        return "TicketFLow no ar";
    }
}