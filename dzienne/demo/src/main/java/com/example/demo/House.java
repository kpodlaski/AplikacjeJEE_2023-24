package com.example.demo;

public class House {
    private int nOfRooms = 3;
    private String Address;
    @Override
    public String toString() {
        return "com.example.demo.House " +
                "nOfRooms=" + nOfRooms +
                ", Address='" + Address + '\'';
    }
    public int getnOfRooms() {
        return nOfRooms;
    }
    public void setnOfRooms(int nOfRooms) {
        this.nOfRooms = nOfRooms;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }

}
