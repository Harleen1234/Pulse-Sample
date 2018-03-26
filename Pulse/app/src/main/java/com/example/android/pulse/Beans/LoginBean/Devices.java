package com.example.android.pulse.Beans.LoginBean;

/**
 * Created by android on 14/12/15.
 */
public class Devices
{
    private String dev_latitude;

    private String dev_longitude;

    private String dev_id;

    private String dev_device_id;

    private String loop_flag;

    private String dev_isassigned;

    private String dev_username;

    private String dev_radius;

    public String getDev_latitude ()
    {
        return dev_latitude;
    }

    public void setDev_latitude (String dev_latitude)
    {
        this.dev_latitude = dev_latitude;
    }

    public String getDev_longitude ()
    {
        return dev_longitude;
    }

    public void setDev_longitude (String dev_longitude)
    {
        this.dev_longitude = dev_longitude;
    }

    public String getDev_id ()
    {
        return dev_id;
    }

    public void setDev_id (String dev_id)
    {
        this.dev_id = dev_id;
    }

    public String getDev_device_id ()
    {
        return dev_device_id;
    }

    public void setDev_device_id (String dev_device_id)
    {
        this.dev_device_id = dev_device_id;
    }

    public String getLoop_flag ()
    {
        return loop_flag;
    }

    public void setLoop_flag (String loop_flag)
    {
        this.loop_flag = loop_flag;
    }

    public String getDev_isassigned ()
    {
        return dev_isassigned;
    }

    public void setDev_isassigned (String dev_isassigned)
    {
        this.dev_isassigned = dev_isassigned;
    }

    public String getDev_username ()
    {
        return dev_username;
    }

    public void setDev_username (String dev_username)
    {
        this.dev_username = dev_username;
    }

    public String getDev_radius ()
    {
        return dev_radius;
    }

    public void setDev_radius (String dev_radius)
    {
        this.dev_radius = dev_radius;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dev_latitude = "+dev_latitude+", dev_longitude = "+dev_longitude+", dev_id = "+dev_id+", dev_device_id = "+dev_device_id+", loop_flag = "+loop_flag+", dev_isassigned = "+dev_isassigned+", dev_username = "+dev_username+", dev_radius = "+dev_radius+"]";
    }
}