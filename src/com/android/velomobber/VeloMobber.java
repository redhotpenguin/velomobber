package com.android.velomobber;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import com.google.android.maps.*;
import java.util.List;

import java.util.List;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.app.AlertDialog;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.ItemizedOverlay;
import java.util.ArrayList;



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

        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable);

        GeoPoint point = new GeoPoint(19240000,-99120000);
        OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");

        itemizedoverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedoverlay);

    }
    @Override
        protected boolean isRouteDisplayed() {
        return false;
    }


private class HelloItemizedOverlay extends ItemizedOverlay {
    Context mContext;

    private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();

    public HelloItemizedOverlay(Drawable defaultMarker) {
        super(boundCenterBottom(defaultMarker));
    }

    public void addOverlay(OverlayItem overlay) {
        mOverlays.add(overlay);
        populate();
    }

    @Override
        public int size() {
        return mOverlays.size();
    }

    @Override
        protected OverlayItem createItem(int i) {
        return mOverlays.get(i);
    }

    @Override
        protected boolean onTap(int index) {
        OverlayItem item = mOverlays.get(index);
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        dialog.setTitle(item.getTitle());
        dialog.setMessage(item.getSnippet());
        dialog.show();
        return true;
    }
}

}