package com.epsilon.coders.vichile_servey.objectes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 3/5/2016.
 */
public enum VehicleTypes {
    CAR ("Car", 1),
    VAN ("Van", 2),
    LORRY("Lorry", 3),
    BUS("Bus", 4),
    BIKE("Bike", 5);

    private final String type;
    private final int id;

    VehicleTypes (String type, int id) {
        this.type = type;
        this.id = id;
    }

    private static final Map<String, VehicleTypes> map = new HashMap<>();
    static {
        for (VehicleTypes en : values()) {
            map.put(en.type, en);
        }
    }

    public static VehicleTypes valueFor(String name) {
        return map.get(name);
    }

    public String getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }
}
