package com.parkinglot.services;

import com.parkinglot.exceptions.InvalidTicketException;
import com.parkinglot.factories.PricingStrategyFactory;
import com.parkinglot.models.Gate;
import com.parkinglot.models.Invoice;
import com.parkinglot.models.Ticket;
import com.parkinglot.repositories.InvoiceRepository;
import com.parkinglot.strategies.pricing_strategy.PricingStrategy;

import java.util.Date;

public class InvoiceService {
    private InvoiceRepository invoiceRepository;
    private GateService gateService;
    private TicketService ticketService;
    private PricingStrategyFactory pricingStrategyFactory;


    public InvoiceService(InvoiceRepository invoiceRepository, GateService gateService, TicketService ticketService, PricingStrategyFactory pricingStrategyFactory) {
        this.invoiceRepository = invoiceRepository;
        this.gateService = gateService;
        this.ticketService = ticketService;
        this.pricingStrategyFactory = pricingStrategyFactory;

    }

    public Invoice generateInvoice(int gateId, int ticketId) throws InvalidTicketException {
        Ticket ticket=ticketService.getTicketById(ticketId);
        if(ticket == null){
            throw new InvalidTicketException("No ticket exists with ticketID: "+ticketId);
        }
        Gate gate=gateService.getGateById(gateId);
        Date exitTime=new Date();
        PricingStrategy pricingStrategy=pricingStrategyFactory.getPricingStrategyFactory(exitTime);
        double amount = pricingStrategy.calculateAmount(ticket.getEntryTime(),exitTime,ticket.getVehicle().getVehicleType());
        Invoice invoice=invoiceRepository.insertInvoice(ticket,gate,exitTime,amount);
        return invoice;
    }
}
