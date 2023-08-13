package com.parkinglot.models;

public class ParkingAttendent extends BaseModel {
    private String name;
    private String email;

    public ParkingAttendent(int id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
