package com.epsilon.coders.vichile_servey;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.epsilon.coders.vichile_servey.objectes.Vehicle;
import com.epsilon.coders.vichile_servey.objectes.VehicleTypes;
import com.epsilon.coders.vichile_servey.services.DatabaseHandler;
import com.epsilon.coders.vichile_servey.services.TimeManager;

import java.sql.Timestamp;
import java.util.Date;



public class MainActivity extends AppCompatActivity {

    DatabaseHandler databaseHandler = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    TimeManager timeManager = null;
    Vehicle vehicle = null;

    public void buttonClickCar(View view) {
        timeManager = new TimeManager();
        vehicle = new Vehicle(VehicleTypes.CAR, timeManager.getDateString(), timeManager.getTimeString());
        databaseHandler.addVehicle(vehicle);
    }

    public void buttonClickVan(View view) {
        timeManager = new TimeManager();
        vehicle = new Vehicle(VehicleTypes.VAN, timeManager.getDateString(), timeManager.getTimeString());
        databaseHandler.addVehicle(vehicle);
    }

    public void buttonClickLorry(View view) {
        timeManager = new TimeManager();
        vehicle = new Vehicle(VehicleTypes.LORRY, timeManager.getDateString(), timeManager.getTimeString());
        databaseHandler.addVehicle(vehicle);
    }

    public void buttonClickBus(View view) {
        timeManager = new TimeManager();
        vehicle = new Vehicle(VehicleTypes.BUS, timeManager.getDateString(), timeManager.getTimeString());
        databaseHandler.addVehicle(vehicle);
    }

    public void buttonClickBike(View view) {
        timeManager = new TimeManager();
        vehicle = new Vehicle(VehicleTypes.BIKE, timeManager.getDateString(), timeManager.getTimeString());
        databaseHandler.addVehicle(vehicle);
    }

    public void buttonClickViewData(View view) {
        Intent intent = new Intent(this, ViewDataActivity.class);
        startActivity(intent);
    }
}
