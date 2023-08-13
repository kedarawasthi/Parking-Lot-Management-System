package com.parkinglot.services;

import com.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.parkinglot.models.*;
import com.parkinglot.repositories.TicketRepository;
import com.parkinglot.strategies.spot_assignment_strategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {

    private TicketRepository ticketRepository;
    private ParkingLotService parkingLotService;
    private VehicleService vehicleService;
    private GateService gateService;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(TicketRepository ticketRepository, ParkingLotService parkingLotService, VehicleService vehicleService, GateService gateService, SpotAssignmentStrategy spotAssignmentStrategy) {
        this.ticketRepository = ticketRepository;
        this.parkingLotService = parkingLotService;
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public Ticket generateTicket(int gateId, String registrationNumber, String vehicleTypeStr) throws ParkingSpotNotFoundException {
        Gate gate=gateService.getGateById(gateId);
        VehicleType vehicleType=VehicleType.getVehicleType(vehicleTypeStr);
        Vehicle vehicle=vehicleService.insertIfNotExists(registrationNumber,vehicleType);
        ParkingLot parkingLot=parkingLotService.getParkingLotByGateId(gateId);
        ParkingSpot parkingSpot=spotAssignmentStrategy.assignSpot(parkingLot,vehicleType);
        Ticket ticket=ticketRepository.insertTicket(vehicle,gate,parkingSpot,new Date());
        return ticket;
    }

    public Ticket getTicketById(int ticketId) {
        return ticketRepository.getTicketById(ticketId);
    }
}
