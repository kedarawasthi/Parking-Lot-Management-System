package com.parkinglot;

import com.parkinglot.controllers.InvoiceController;
import com.parkinglot.controllers.TicketController;
import com.parkinglot.dtos.GenerateInvoiceRequestDTO;
import com.parkinglot.dtos.GenerateInvoiceResponseDTO;
import com.parkinglot.dtos.GenerateTicketRequestDTO;
import com.parkinglot.dtos.GenerateTicketResponseDTO;
import com.parkinglot.factories.PricingStrategyFactory;
import com.parkinglot.models.*;
import com.parkinglot.repositories.*;
import com.parkinglot.services.*;
import com.parkinglot.strategies.pricing_strategy.WeekdayPricingStrategy;
import com.parkinglot.strategies.pricing_strategy.WeekendPricingStrategy;
import com.parkinglot.strategies.spot_assignment_strategy.NearestFirstParkingAssignmentStrategy;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        List<ParkingFloor> parkingFloors= Arrays.asList(
                new ParkingFloor(1,Arrays.asList(
                        new ParkingSpot(1,"A100", SpotStatus.AVAILABLE, VehicleType.CAR),
                        new ParkingSpot(2,"A101", SpotStatus.AVAILABLE, VehicleType.SUV)
                ),1, FloorStatus.OPERATIONAL ),
                new ParkingFloor(2,Arrays.asList(
                        new ParkingSpot(1,"A200", SpotStatus.AVAILABLE, VehicleType.CAR),
                        new ParkingSpot(2,"A201", SpotStatus.AVAILABLE, VehicleType.CAR)
                ),2, FloorStatus.OPERATIONAL )
        );

        List<Gate> gates=Arrays.asList(
                new Gate(1,"G1",GateStatus.OPERATIONAL, new ParkingAttendent(1,"raju","raju@abc"),GateType.ENTRY),
                new Gate(2,"G2",GateStatus.OPERATIONAL, new ParkingAttendent(2,"prav","prav@abc"),GateType.EXIT)
        );

        ParkingLot parkingLot = new ParkingLot(1,parkingFloors,gates,"PL1","mathura",new Date(),new Date());

        Map<Integer,ParkingLot> parkingLotMap=new HashMap(){{
                put(1,parkingLot);
        }};

        ParkingLotRepository parkingLotRepository=new ParkingLotRepository(parkingLotMap);
        ParkingLotService parkingLotService=new ParkingLotService(parkingLotRepository);

        Map<Integer,Gate> gateMap=new HashMap<>();
        for(Gate gate:gates){
            gateMap.put(gate.getId(),gate);
        }
        GateRepository gateRepository=new GateRepository(gateMap);
        GateService gateService=new GateService(gateRepository);

        VehicleRepository vehicleRepository=new VehicleRepository();
        VehicleService vehicleService=new VehicleService(vehicleRepository);

        TicketRepository ticketRepository=new TicketRepository();
        TicketService ticketService=new TicketService(ticketRepository,parkingLotService,vehicleService,gateService,new NearestFirstParkingAssignmentStrategy());
        TicketController ticketController=new TicketController(ticketService);

        //======================================================================Car with number KA1234 enters parking lot=====================================

        GenerateTicketRequestDTO generateTicketRequestDTO=new GenerateTicketRequestDTO(1,"KA1234",VehicleType.CAR.name());
        GenerateTicketResponseDTO generateTicketResponseDTO=ticketController.generateTicket(generateTicketRequestDTO);
        Ticket ticket=generateTicketResponseDTO.getTicket();
        System.out.println(generateTicketResponseDTO.getResponse().getMessage());

        Map<Integer,Slab> slabMap=new HashMap(){{
            put(1,new Slab(1,0,2,10,VehicleType.CAR));
            put(2,new Slab(2,2,4,20,VehicleType.CAR));
            put(3,new Slab(3,4,-1,50,VehicleType.CAR));
            put(4,new Slab(4,0,-1,21,VehicleType.SUV));
        }};
        SlabRepository slabRepository=new SlabRepository(slabMap);
        PricingStrategyFactory pricingStrategyFactory=new PricingStrategyFactory(new WeekdayPricingStrategy(),new WeekendPricingStrategy(slabRepository));
        InvoiceRepository invoiceRepository=new InvoiceRepository();
        InvoiceService invoiceService=new InvoiceService(invoiceRepository,gateService,ticketService,pricingStrategyFactory);
        InvoiceController invoiceController=new InvoiceController(invoiceService);

        //======================================================================Car with number KA1234 exits parking lot=====================================
        GenerateInvoiceRequestDTO generateInvoiceRequestDTO=new GenerateInvoiceRequestDTO(1,2);
        GenerateInvoiceResponseDTO generateInvoiceResponseDTO=invoiceController.generateInvoice(generateInvoiceRequestDTO);
        Invoice invoice=generateInvoiceResponseDTO.getInvoice();
        System.out.println(generateInvoiceResponseDTO.getResponse().getMessage());
    }
}
