package com.example.android.pulse.MainClasses;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.pulse.Beans.PlacesBean.GetAddPlaces;
import com.example.android.pulse.Beans.PlacesBean.GetAddressGecoder;
import com.example.android.pulse.Beans.PlacesBean.PlaceBean;
import com.example.android.pulse.Geofence.GPSTracker;
import com.example.android.pulse.R;
import com.example.android.pulse.retrofit.ApiEndpointInterface;
import com.example.android.pulse.retrofit.RetroUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by android on 16/12/15.
 */
public class AddPlaceActivity extends AppCompatActivity implements View.OnClickListener, GoogleMap.OnMapLongClickListener {
    private Toolbar toolbar;
    GoogleMap googleMap;
    Marker marker1;
    Circle circle;
    GPSTracker gps;
    Button Done;
    EditText Address, place;
    private int rad;
    private double latitude1, longitude1;
    private String latitude, longitude;
    private HashMap<String, Integer> Radius;
    LatLng latLng;
    CircleOptions circleOptions;
    MarkerOptions marker;
    private String LocAddress;
    private String LocAddress1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_places);
        setToolbar();
        Address = (EditText) findViewById(R.id.LocAddress);
        place = (EditText) findViewById(R.id.placename);
        Done = (Button) findViewById(R.id.done_button);
        rad = 100;

        Done.setOnClickListener(this);
        gps = new GPSTracker(getApplicationContext());


        latitude1 = gps.getLatitude();
        longitude1 = gps.getLongitude();

        latitude = "" + latitude1;
        longitude = "" + longitude1;
        latLng = new LatLng(latitude1, longitude1);
        SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        // Getting GoogleMap object from the fragment
        googleMap = fm.getMap();

        // Enabling MyLocation Layer of Google Map
//        googleMap.setMyLocationEnabled(true);

        Toast.makeText(getApplicationContext(), String.valueOf(rad), Toast.LENGTH_SHORT).show();
        // Getting LocationManager object from System Service LOCATION_SERVICE
        marker = new MarkerOptions().position(new LatLng(latitude1, longitude1)).title(latLng.latitude + " : " + latLng.longitude);

// Changing marker icon
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.loc1_icon));

// adding marker
        marker1 = googleMap.addMarker(marker);
        circleOptions = new CircleOptions().center(latLng).radius(rad)
                .fillColor(0x400869ca).strokeColor(Color.TRANSPARENT).strokeWidth(2);
        circle = googleMap.addCircle(circleOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        googleMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setIndoorEnabled(false);
        googleMap.setMyLocationEnabled(false);
        LocAddress = latitude1 + "," + longitude1;


        LocAddress1 = String.valueOf(latLng);
        Log.e("encodeddd", LocAddress);
        Log.e("latlng", String.valueOf(latLng));

        getMyLocationAddress();

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng1) {
                if (marker1 != null) {
                    marker1.remove();
                }
                latLng = latLng1;
                circleOptions = new CircleOptions()
                        .center(latLng)   //set center
                        .radius(rad)   //set radius in meters
                        .fillColor(0x400869ca)  //default
                        .strokeColor(Color.TRANSPARENT)
                        .strokeWidth(2);


                // Creating a marker
                marker = new MarkerOptions();

                // Setting the position for the marker
                marker.position(latLng);

                // Setting the title for the marker.
                // This will be displayed on taping the marker
                marker.title(latLng.latitude + " : " + latLng.longitude);
                latitude1 = latLng1.latitude;
                longitude1 = latLng1.longitude;


                BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.loc1_icon);
                marker.icon(icon);

                marker1 = googleMap.addMarker(marker);
                circle = googleMap.addCircle(circleOptions);
                // Clears the previously touched position
                googleMap.clear();

                // Animating to the touched position
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(16));

                // Placing a marker on the touched position
                googleMap.addMarker(marker);

                latitude = "" + latitude1;
                longitude = "" + longitude1;
                LocAddress = latitude + "," + longitude;


                 /*   LocAddress1= URLEncoder.encode(LocAddress, "UTF-8");*/

                Log.e("encodeddd", LocAddress);
                getMyLocationAddress();
            }
        });
    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar.setNavigationIcon(R.drawable.back_arrow);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.done_button) {
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        }
    }

    @Override
    public void onMapLongClick(LatLng latLng1) {
        if (marker1 != null) {
            marker1.remove();
        }

        rad = 100;
        latLng = latLng1;


        CircleOptions circleOptions = new CircleOptions()
                .center(latLng)   //set center
                .radius(rad)   //set radius in meters
                .fillColor(Color.TRANSPARENT)  //default
                .strokeColor(Color.BLUE)
                .strokeWidth(5);


        // Creating a marker
        marker = new MarkerOptions();

        // Setting the position for the marker
        marker.position(latLng);

        // Setting the title for the marker.

        // This will be displayed on taping the marker
        marker.title(latLng.latitude + " : " + latLng.longitude);

        String latitude1 = String.valueOf(latLng1.latitude);
        String longitude1 = String.valueOf(latLng1.longitude);
        LocAddress = latitude1 + "," + longitude1;
        try {
            LocAddress1 = URLEncoder.encode(LocAddress, "UTF-8");
            Log.e("encodeddd", LocAddress1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.loc1_icon);
        marker.icon(icon);

        marker1 = googleMap.addMarker(marker);
        circle = googleMap.addCircle(circleOptions);
        // Clears the previously touched position
        googleMap.clear();

        // Animating to the touched position
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(16));

        // Placing a marker on the touched position
        googleMap.addMarker(marker);
        // Adding Marker on the touched location with address
        getMyLocationAddress();

    }

    private void getMyLocationAddress() {
        Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);

        try {

            //Place your latitude and longitude
            List<android.location.Address> addresses = geocoder.getFromLocation(latitude1, longitude1, 1);
            String lat = String.valueOf(latitude1);
            String lon = String.valueOf(longitude1);

            if (addresses != null) {

                Address fetchedAddress = addresses.get(0);
                StringBuilder strAddress = new StringBuilder();

                for (int i = 0; i < fetchedAddress.getMaxAddressLineIndex(); i++) {
                    strAddress.append(fetchedAddress.getAddressLine(i)).append("\n");
                }

                Address.setText(strAddress.toString());
                String place_address = strAddress.toString();

            } else
                Address.setText("No location found..!");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Could not get address..!", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.places_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_item1:

                addRadius(latLng);
                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void addRadius(LatLng latLng) {
        rad = 100;
        if (circle != null) {
            circle.remove();
        }
        circleOptions = new CircleOptions().center(latLng).radius(rad)
                .fillColor(0x400869ca).strokeColor(Color.TRANSPARENT).strokeWidth(2);
        circle = googleMap.addCircle(circleOptions);
        PlaceBean placeBean = new PlaceBean();
        placeBean.setLatLng(latLng);
        placeBean.setName(Address.getText().toString());
        Utility.places.add(placeBean);
    }
}
