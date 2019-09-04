package com.example.realestate;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.service.media.MediaBrowserService;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Location extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

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

        int number = getIntent().getExtras().getInt("marker_no");

        if(number==1)
        {
            LatLng loc1 = new LatLng(28.5324, 77.4052);
            mMap.addMarker(new MarkerOptions().position(loc1).title("Noida Extension"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc1));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc1,14.0f));
        }

        if(number==2)
        {
            LatLng loc2 = new LatLng(28.5607, 77.0597);
            mMap.addMarker(new MarkerOptions().position(loc2).title("Sec 22, Dwarka"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc2));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc2,14.0f));
        }
        if(number==3)
        {
            LatLng loc2 = new LatLng(28.4052, 77.2877);
            mMap.addMarker(new MarkerOptions().position(loc2).title("Sec-48, Faridabad"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc2));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc2,14.0f));
        }
        if(number==4)
        {
            LatLng loc2 = new LatLng(28.4621, 77.0464);
            mMap.addMarker(new MarkerOptions().position(loc2).title("Sec-15, Gurgaon"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc2));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc2,14.0f));
        }
        if(number==5)
        {
            LatLng loc2 = new LatLng(28.6691, 77.0929);
            mMap.addMarker(new MarkerOptions().position(loc2).title("Pashchim Vihar, Delhi"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc2));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc2,14.0f));
        }
        if(number==6)
        {
            LatLng loc2 = new LatLng(30.7583, 76.7841);
            mMap.addMarker(new MarkerOptions().position(loc2).title("Sector-11, Chandigarh"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc2));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc2,14.0f));
        }
        if(number==7)
        {
            LatLng loc2 = new LatLng(12.9138, 77.6293);
            mMap.addMarker(new MarkerOptions().position(loc2).title("Sector-6, Bangalore"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc2));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc2,14.0f));
        }
        if(number==8)
        {
            LatLng loc2 = new LatLng(28.5802, 77.3181);
            mMap.addMarker(new MarkerOptions().position(loc2).title("Sector-3, Noida"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc2));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc2,14.0f));
        }

    }

}
