package com.example.android.pulse.Beans.PlacesBean;

/**
 * Created by android on 18/12/15.
 */
public class GetAddPlaces
{
    private String MSG;

    private Data1 data;

    private String CODE;

    public String getMSG ()
    {
        return MSG;
    }

    public void setMSG (String MSG)
    {
        this.MSG = MSG;
    }

    public Data1 getData ()
    {
        return data;
    }

    public void setData (Data1 data)
    {
        this.data = data;
    }

    public String getCODE ()
    {
        return CODE;
    }

    public void setCODE (String CODE)
    {
        this.CODE = CODE;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [MSG = "+MSG+", data = "+data+", CODE = "+CODE+"]";
    }
}
