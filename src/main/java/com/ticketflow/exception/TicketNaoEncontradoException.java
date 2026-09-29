package com.ticketflow.exception;

public class TicketNaoEncontradoException extends RuntimeException{

    public  TicketNaoEncontradoException(Long id) {
        super("Ticket nao encontrado: " + id);
    }
}
