package com.epsilon.coders.vichile_servey;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.epsilon.coders.vichile_servey.objectes.Vehicle;
import com.epsilon.coders.vichile_servey.services.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;



public class ViewDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        setView(databaseHandler);
    }

    private void setView(DatabaseHandler databaseHandler) {
        TableLayout table = (TableLayout)findViewById(R.id.table_all_data);

        List<Vehicle> vehicles = databaseHandler.getAllVehicles();

        if (vehicles != null && vehicles.size() > 0) {
            Log.d("View Data Activity", "setView: 1 or More vehicles Recorded !");
            for (Vehicle vehicle : vehicles) {

                TableRow row = new TableRow(ViewDataActivity.this);

                TextView vehicleType = new  TextView(ViewDataActivity.this);
                vehicleType.setTextSize(20);
                vehicleType.setText(vehicle.getVehicleType().getType());
                row.addView(vehicleType);

                TextView date = new  TextView(ViewDataActivity.this);
                date.setText(vehicle.getDateString());
                row.addView(date);

                TextView time = new TextView(ViewDataActivity.this);
                time.setText(vehicle.getTimeString());
                row.addView(time);

                table.addView(row);
            }
        }
        else {
            Toast.makeText(this, "No Data to Show", Toast.LENGTH_LONG).show();
        }
    }
}
