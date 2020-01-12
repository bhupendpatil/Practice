package com.example.myapplication2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView l1, l2, l3;
    Button b1;
    double lat, longg;
    LocationManager lm;
    LocationListener ln;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1 = (TextView) findViewById(R.id.textView);
        l2 = (TextView) findViewById(R.id.textView2);
        l3 = (TextView) findViewById(R.id.textView3);
        b1 = (Button) findViewById(R.id.button);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l1.setText("Latitude " + lat);
                l2.setText("Longitude " + longg);
                if (lat < 10 && longg > 80) {
                    l3.setText("You are in the right place");
                } else {
                    l3.setText("You are in the wrong place");
                }

            }
        });
        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        ln = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (location != null) {
                    lat = location.getLatitude();
                    longg = location.getLongitude();
                    l1.setText("Latitude " + lat);
                    l2.setText("Longitute" + longg);
                }

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, ln);

    }
}
