package com.example.android.pulse.Beans.PlacesBean;

/**
 * Created by android on 18/12/15.
 */
public class Results
{
    private String place_id;

    private String formatted_address;

    public String getPlace_id ()
    {
        return place_id;
    }

    public void setPlace_id (String place_id)
    {
        this.place_id = place_id;
    }

    public String getFormatted_address ()
    {
        return formatted_address;
    }

    public void setFormatted_address (String formatted_address)
    {
        this.formatted_address = formatted_address;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [place_id = "+place_id+", formatted_address = "+formatted_address+"]";
    }
}
