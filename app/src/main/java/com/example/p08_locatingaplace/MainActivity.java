package com.example.p08_locatingaplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback(){
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                LatLng poi_Singapore = new LatLng(1.346850, 103.816972);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Singapore,
                        15));

                UiSettings ui = map.getUiSettings();
                ui.setCompassEnabled(true);
                ui.setZoomControlsEnabled(true);

                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }

            }
        });

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    LatLng poi_North = new LatLng(1.461708, 103.813500);
                    Marker cp1 = map.addMarker(new
                            MarkerOptions()
                            .position(poi_North)
                            .title("HQ - North")
                            .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm Tel:65433456")
                            .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.btn_star_big_on)));

                    LatLng poi_Central = new LatLng(1.300542, 103.841226);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Central,
                            15));
                    Marker cp2 = map.addMarker(new
                            MarkerOptions()
                            .position(poi_Central)
                            .title("HQ - Central")
                            .snippet("Block 3A, Orchard Ave 3, 134542 Operating hours: 11am-8pm Tel:67788652")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng poi_East = new LatLng(1.350057, 103.934452);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_East,
                            15));
                    Marker cp3 = map.addMarker(new
                            MarkerOptions()
                            .position(poi_East)
                            .title("HQ - East")
                            .snippet("Block 555, Tampines Ave 3, 287788 Operating hours: 9am-5pm Tel:66776677")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    LatLng poi_Central = new LatLng(1.300542, 103.841226);
                    Marker cp1 = map.addMarker(new
                            MarkerOptions()
                            .position(poi_Central)
                            .title("HQ - Central")
                            .snippet("Block 3A, Orchard Ave 3, 134542 Operating hours: 11am-8pm Tel:67788652")
                            .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.btn_star_big_on)));

                    LatLng poi_North = new LatLng(1.461708, 103.8135006);
                    Marker cp2 = map.addMarker(new
                            MarkerOptions()
                            .position(poi_North)
                            .title("HQ - North")
                            .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm Tel:65433456")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng poi_East = new LatLng(1.350057, 103.934452);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_North,
                            15));
                    Marker cp3 = map.addMarker(new
                            MarkerOptions()
                            .position(poi_East)
                            .title("HQ - East")
                            .snippet("Block 555, Tampines Ave 3, 287788 Operating hours: 9am-5pm Tel:66776677")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    LatLng poi_East = new LatLng(1.350057, 103.934452);
                    Marker cp1 = map.addMarker(new
                            MarkerOptions()
                            .position(poi_East)
                            .title("HQ - East")
                            .snippet("Block 555, Tampines Ave 3, 287788 Operating hours: 9am-5pm Tel:66776677")
                            .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.btn_star_big_on)));

                    LatLng poi_North = new LatLng(1.461708, 103.8135006);
                    Marker cp2 = map.addMarker(new
                            MarkerOptions()
                            .position(poi_North)
                            .title("HQ - North")
                            .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm Tel:65433456")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng poi_Central = new LatLng(1.300542, 103.841226);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Central,
                            15));
                    Marker cp3 = map.addMarker(new
                            MarkerOptions()
                            .position(poi_Central)
                            .title("HQ - Central")
                            .snippet("Block 3A, Orchard Ave 3, 134542 Operating hours: 11am-8pm Tel:67788652")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                }
            }
        });

    }
}


