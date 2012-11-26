package com.android.velomobber;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.maps.*;

public class VeloMobber extends MapActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
    }
    @Override
        protected boolean isRouteDisplayed() {
        return false;
    }
}
