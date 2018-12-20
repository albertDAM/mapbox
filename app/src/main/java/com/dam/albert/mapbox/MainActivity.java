package com.dam.albert.mapbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerViewOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity {
    private MapView mapView;
    private Button boto;
    private MapboxMap mapboxMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mapbox.getInstance(this, "pk.eyJ1IjoiYWxiZXJ0ZGFtIiwiYSI6ImNqcHd1eHRyajBmYTYzeHBxbHZmem9mOGgifQ.kSu5iJwepRxVlQM57V4WAg");

        setContentView(R.layout.activity_main);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        boto = (Button) findViewById(R.id.boto);
        boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CameraPosition position = new CameraPosition.Builder()
                        .target(new LatLng(51.50550, -0.07520))
                        .zoom(10)
                        .tilt(20)
                        .build();

                mapboxMap.animateCamera(
                        CameraUpdateFactory.newCameraPosition(position), 2000);
            }
        });
        /*https://www.google.com/maps/place/Institut+Escola+del+Treball/
        @41.3890464,2.1454964,17z/data=!3m1!4b1!4m5!3m4!1s0x12a4a2847eeed3b5:0xfcbfd60966182d80!8m2!3d41.3890464!4d2.1476851*/

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MainActivity.this.mapboxMap = mapboxMap;
                mapboxMap.addMarker(new MarkerViewOptions()
                        .position(new LatLng(41.3890464, 2.1454964)))
                        .setTitle("Edt, Barcelona");
                mapboxMap.addMarker(new MarkerViewOptions()
                        .position(new LatLng(41.3885579, 2.1486348))
                        .title("Retornino, Barcelona"));
            }
        });

    }
        @Override
        public void onStart() {
            super.onStart();
            mapView.onStart();
        }

        @Override
        public void onResume() {
            super.onResume();
            mapView.onResume();
        }

        @Override
        public void onPause() {
            super.onPause();
            mapView.onPause();
        }

        @Override
        public void onStop() {
            super.onStop();
            mapView.onStop();
        }

        @Override
        public void onLowMemory() {
            super.onLowMemory();
            mapView.onLowMemory();
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            mapView.onDestroy();
        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            mapView.onSaveInstanceState(outState);
        }
    }

