package com.parkinglot.dtos;

import com.parkinglot.models.Ticket;

public class GenerateTicketResponseDTO {
    private Ticket ticket;
    private Response response;

    public GenerateTicketResponseDTO(Ticket ticket, Response response) {
        this.ticket = ticket;
        this.response = response;
    }

    public static GenerateTicketResponseDTO getSuccessResponse(Ticket ticket){
        return new GenerateTicketResponseDTO(ticket,new Response(ResponseStatus.SUCCESS,"Successfully generated a ticket"));
    }

    public static GenerateTicketResponseDTO getFailureResponse(String message){
        return new GenerateTicketResponseDTO(null,new Response(ResponseStatus.FAILURE,message));
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Response getResponse() {
        return response;
    }
}
