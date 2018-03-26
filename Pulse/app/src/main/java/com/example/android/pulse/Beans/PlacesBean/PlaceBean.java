package com.example.android.pulse.Beans.PlacesBean;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Neeraj on 2018-03-22.
 */

public class PlaceBean {

    private String name;
    private LatLng latLng;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
