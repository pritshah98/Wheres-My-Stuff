package com.example.seekers.wheresmystuff;

import android.location.Address;
import android.location.Geocoder;
import android.provider.Telephony;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class to handle adding markers to map and viewing map
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        try {
            addAllMarkers();
        } catch (IOException io) {
            Log.d("Exception", io.getMessage());
        }
        CameraPosition pos = new CameraPosition(new LatLng(30.00, -93), 0, 0, 0);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(pos));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
    }

    public void addMarker(Item item) throws IOException {
        Geocoder coder = new Geocoder(this);
        ArrayList<Address> newAddress = (ArrayList<Address>) coder.getFromLocationName(item.getAddress(), 10);
        for (Address add : newAddress) {
            double longitude = add.getLongitude();
            double latitude = add.getLatitude();
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(latitude, longitude))
                    .title(item.getName())
                    .snippet(item.getAddress() + "/" + item.getColor() + "/" + item.getDescription()));
        }
    }

    public void addAllMarkers() throws IOException {
        for (int i = 0; i < WelcomeScreenActivity.lostItemList.getLostItemList().size(); i++) {
            if (WelcomeScreenActivity.lostItemList.getLostItemList().get(i).getAddress() != null) {
                addMarker(WelcomeScreenActivity.lostItemList.getLostItemList().get(i));
            }
        }
        for (int i = 0; i < WelcomeScreenActivity.foundItemList.getFoundItemList().size(); i++) {
            if (WelcomeScreenActivity.foundItemList.getFoundItemList().get(i).getAddress() != null) {
                addMarker(WelcomeScreenActivity.foundItemList.getFoundItemList().get(i));
            }
        }
    }
}
