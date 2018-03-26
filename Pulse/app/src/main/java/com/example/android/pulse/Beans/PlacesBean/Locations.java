package com.example.android.pulse.Beans.PlacesBean;

/**
 * Created by android on 16/12/15.
 */
public class Locations
{
    private String loc_place_address;

    private String loc_place_name;

    private String loc_user_id;

    private String loc_id;

    private String loc_group_id;

    private String loc_user_longitude;

    private String loc_user_latitude;

    private String loc_user_radius;

    public String getLoc_place_address ()
    {
        return loc_place_address;
    }

    public void setLoc_place_address (String loc_place_address)
    {
        this.loc_place_address = loc_place_address;
    }

    public String getLoc_place_name ()
    {
        return loc_place_name;
    }

    public void setLoc_place_name (String loc_place_name)
    {
        this.loc_place_name = loc_place_name;
    }

    public String getLoc_user_id ()
    {
        return loc_user_id;
    }

    public void setLoc_user_id (String loc_user_id)
    {
        this.loc_user_id = loc_user_id;
    }

    public String getLoc_id ()
    {
        return loc_id;
    }

    public void setLoc_id (String loc_id)
    {
        this.loc_id = loc_id;
    }

    public String getLoc_group_id ()
    {
        return loc_group_id;
    }

    public void setLoc_group_id (String loc_group_id)
    {
        this.loc_group_id = loc_group_id;
    }

    public String getLoc_user_longitude ()
    {
        return loc_user_longitude;
    }

    public void setLoc_user_longitude (String loc_user_longitude)
    {
        this.loc_user_longitude = loc_user_longitude;
    }

    public String getLoc_user_latitude ()
    {
        return loc_user_latitude;
    }

    public void setLoc_user_latitude (String loc_user_latitude)
    {
        this.loc_user_latitude = loc_user_latitude;
    }

    public String getLoc_user_radius ()
    {
        return loc_user_radius;
    }

    public void setLoc_user_radius (String loc_user_radius)
    {
        this.loc_user_radius = loc_user_radius;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [loc_place_address = "+loc_place_address+", loc_place_name = "+loc_place_name+", loc_user_id = "+loc_user_id+", loc_id = "+loc_id+", loc_group_id = "+loc_group_id+", loc_user_longitude = "+loc_user_longitude+", loc_user_latitude = "+loc_user_latitude+", loc_user_radius = "+loc_user_radius+"]";
    }
}