package com.epsilon.coders.vichile_servey.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.epsilon.coders.vichile_servey.objectes.Vehicle;
import com.epsilon.coders.vichile_servey.objectes.VehicleTypes;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Thisaru on 3/5/2016.
 * Thw data base Handler claas.
 * Add / Insert Records
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "vehicle_servey";

    private static final String TABLE_NAME = "vehical_details";

    // Column Names
    private static final String KEY_ID = "id";
    private static final String KEY_TYPE = "vehicleType";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE =
                "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_TYPE + " INTEGER, "
                + KEY_DATE + " TEXT, "
                + KEY_TIME + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public void addVehicle (Vehicle vehicle) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        String getCountQuery = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(getCountQuery, null);

        int count = cursor.getCount();

        values.put(KEY_ID, ++count);
        values.put(KEY_TYPE, vehicle.getVehicleTypeId()); // Vehicle Type (String) from the ENUM
        values.put(KEY_DATE, vehicle.getDateString());
        values.put(KEY_TIME, vehicle.getTimeString());

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        Log.d("Database Handler", "addVehicle: Added Vehicle");
        db.close(); // Closing database connection
    }

    public List<Vehicle> getAllVehicles () {
        List<Vehicle> vehicleList = new ArrayList<>();

        String selectQuery = "Select * from " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            Log.d("Database Handler", "Cursor has data !!!");
            do {
                Vehicle vehicle = new Vehicle();

                int vehicleTypeId = cursor.getInt(1);
                String dateString = cursor.getString(2);
                String timeString = cursor.getString(3);
                String vehicleType = "";

                for (VehicleTypes type: VehicleTypes.values()) {
                    if (vehicleTypeId == type.getId()) {
                        vehicleType = type.getType();
                    }
                }

                vehicle.setVehicleType(VehicleTypes.valueFor(vehicleType));
                vehicle.setDateString(dateString);
                vehicle.setTimeString(timeString);

                vehicleList.add(vehicle);

            } while (cursor.moveToNext());
        }

        cursor.close();
        return vehicleList;
    }
}
