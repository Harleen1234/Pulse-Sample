package com.example.android.pulse.Beans.PlacesBean;

/**
 * Created by android on 16/12/15.
 */
public class Data
{
    private Locations[] locations;

    public Locations[] getLocations ()
    {
        return locations;
    }

    public void setLocations (Locations[] locations)
    {
        this.locations = locations;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [locations = "+locations+"]";
    }
}