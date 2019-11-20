package com.example.hsport.fixtopia092;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class UserInfo extends AppCompatActivity implements OnMapReadyCallback {
    private EditText etUserName;
    private EditText etUserNum;
    private GoogleMap googleMap;
    LocationManager locationManager;
    private static final int DEFAULT_ZOOM = 15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        etUserName = findViewById(R.id.etUserName);
        etUserNum = findViewById(R.id.etUserNumber);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public void onBackPressed() {
        super.onBackPressed();
        AdapterProblemsClass.vvv = "";
        AdapterProblemsClass.row_index2 = -1;
    }

}
