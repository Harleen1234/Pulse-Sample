package com.example.android.pulse.Beans.LoginBean;

/**
 * Created by android on 14/12/15.
 */
public class GetLoginDetailsBean
{
    private String MSG;

    private Data data;

    private String CODE;

    public String getMSG ()
    {
        return MSG;
    }

    public void setMSG (String MSG)
    {
        this.MSG = MSG;
    }

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
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