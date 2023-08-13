package com.parkinglot.controllers;

import com.parkinglot.dtos.GenerateInvoiceRequestDTO;
import com.parkinglot.dtos.GenerateInvoiceResponseDTO;
import com.parkinglot.models.Invoice;
import com.parkinglot.services.InvoiceService;

import java.util.Date;

public class InvoiceController {
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public GenerateInvoiceResponseDTO generateInvoice(GenerateInvoiceRequestDTO generateInvoiceRequestDTO){
        try{
            int gateId= generateInvoiceRequestDTO.getGateId();
            int ticketId= generateInvoiceRequestDTO.getTicketId();
            Invoice invoice = invoiceService.generateInvoice(gateId,ticketId);
            return GenerateInvoiceResponseDTO.getSuccessResponse(invoice);
        }
        catch (Exception e){
            return GenerateInvoiceResponseDTO.getFailureResponse(e.getMessage());
        }
    }
}
