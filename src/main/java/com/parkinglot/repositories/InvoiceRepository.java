package com.parkinglot.repositories;

import com.parkinglot.models.Gate;
import com.parkinglot.models.Invoice;
import com.parkinglot.models.Ticket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InvoiceRepository {
    private Map<Integer, Invoice> map;
    private static int id=0;

    public InvoiceRepository() {
        this.map = new HashMap<>();
    }
    public InvoiceRepository(Map<Integer, Invoice> map) {
        this.map = map;
    }

    public Invoice insertInvoice(Ticket ticket, Gate gate, Date exitTime, double amount) {
      this.id++;
      Invoice invoice=new Invoice(id,ticket,gate,exitTime,gate.getParkingAttendent());
      map.put(id,invoice);
      return invoice;
    }
}
