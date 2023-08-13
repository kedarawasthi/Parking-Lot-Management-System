package com.parkinglot.dtos;

import com.parkinglot.models.Invoice;;

public class GenerateInvoiceResponseDTO {
    private Invoice invoice;
    private Response response;

    public GenerateInvoiceResponseDTO(Invoice invoice, Response response) {
        this.invoice = invoice;
        this.response = response;
    }

    public static GenerateInvoiceResponseDTO getSuccessResponse(Invoice invoice){
        return new GenerateInvoiceResponseDTO(invoice,new Response(ResponseStatus.SUCCESS,"Successfully generated a Invoice"));
    }

    public static GenerateInvoiceResponseDTO getFailureResponse(String message){
        return new GenerateInvoiceResponseDTO(null,new Response(ResponseStatus.FAILURE,message));
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Response getResponse() {
        return response;
    }
}
