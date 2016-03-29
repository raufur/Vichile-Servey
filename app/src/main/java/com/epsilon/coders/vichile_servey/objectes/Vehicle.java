package com.epsilon.coders.vichile_servey.objectes;

import java.sql.Timestamp;

/**
 * Created by HP on 3/5/2016.
 */
public class Vehicle {
    private VehicleTypes vehicleType;
    private String dateString, timeString;

    private static final int NANO_SECOND_SPLITTER = 19;

    public Vehicle (VehicleTypes type, String dateString, String timeString) {
        this.vehicleType = type;
        this.dateString = dateString;
        this.timeString = timeString;
    }

    public Vehicle() {

    }

    public VehicleTypes getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getTimeString() {
        return timeString;
    }
    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String getDateString() {
        return dateString;
    }
    public void setDateString (String dateTimeString) {
        this.dateString = dateTimeString;
    }

    public int getVehicleTypeId () {
        return vehicleType.getId();
    }
}
