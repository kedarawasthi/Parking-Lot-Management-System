package com.parkinglot.dtos;

import java.util.Date;

public class GenerateInvoiceRequestDTO {
    private int ticketId;
    private int gateId;


    public GenerateInvoiceRequestDTO(int ticketId, int gateId) {
        this.ticketId = ticketId;
        this.gateId = gateId;

    }

    public int getTicketId() {
        return ticketId;
    }

    public int getGateId() {
        return gateId;
    }


}
