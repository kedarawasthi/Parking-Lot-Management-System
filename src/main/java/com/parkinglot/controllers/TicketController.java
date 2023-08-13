package com.parkinglot.controllers;

import com.parkinglot.dtos.GenerateTicketRequestDTO;
import com.parkinglot.dtos.GenerateTicketResponseDTO;
import com.parkinglot.models.Ticket;
import com.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO generateTicketRequestDTO){
        // need Vehicle object,
        // gate is input
        // entry time and parking spot are sys generated
        // parking attendent is also not input, it can chnge based on shifts

        // so need vehicale and gate as input
        int gateId= generateTicketRequestDTO.getGateId();
        String registrationNumber= generateTicketRequestDTO.getRegistrationNumber();
        String vehicleType= generateTicketRequestDTO.getVehicleType();
        try{
            Ticket ticket=ticketService.generateTicket(gateId,registrationNumber,vehicleType);
            return GenerateTicketResponseDTO.getSuccessResponse(ticket);
        }
        catch (Exception e){
            return GenerateTicketResponseDTO.getFailureResponse(e.getMessage());
        }


    }
}
