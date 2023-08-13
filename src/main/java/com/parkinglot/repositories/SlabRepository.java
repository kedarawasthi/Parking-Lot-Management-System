package com.parkinglot.repositories;

import com.parkinglot.models.Slab;
import com.parkinglot.models.Vehicle;
import com.parkinglot.models.VehicleType;

import java.util.*;

public class SlabRepository {
    private Map<Integer, Slab> map;

    public SlabRepository() {
        this.map=new HashMap<>();
    }

    public SlabRepository(Map<Integer, Slab> map) {
        this.map = map;
    }

    public Map<Integer, Slab> getMap() {
        return map;
    }
    public List<Slab> getSlabByVehicleType(VehicleType vehicleType){
        List<Slab> slabs=new ArrayList<>();
        for(Map.Entry<Integer,Slab> en:map.entrySet()){
            if(en.getValue().getVehicleType().equals(vehicleType)){
                slabs.add(en.getValue());
            }
        }
        Collections.sort(slabs,(a,b)->a.getStartHour() - b.getStartHour());
        return slabs;
    }
}
