package com.example.android.pulse.Beans.LoginBean;

/**
 * Created by android on 14/12/15.
 */
public class Data
{
    private Locations[] locations;

    private Devices[] devices;

    private User user;

    public Locations[] getLocations ()
    {
        return locations;
    }

    public void setLocations (Locations[] locations)
    {
        this.locations = locations;
    }

    public Devices[] getDevices ()
    {
        return devices;
    }

    public void setDevices (Devices[] devices)
    {
        this.devices = devices;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [locations = "+locations+", devices = "+devices+", user = "+user+"]";
    }
}