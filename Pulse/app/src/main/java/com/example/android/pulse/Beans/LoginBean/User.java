package com.example.android.pulse.Beans.LoginBean;

/**
 * Created by android on 14/12/15.
 */
public class User
{
    private String phone;

    private String user_radius;

    private String state;

    private String img;

    private String address1;

    private String address2;

    private String user_email;

    private String user_longitude;

    private String country;

    private String city;

    private String user_name;

    private String user_latitude;

    private String user_id;

    private String user_username;

    private String user_group_id;

    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public String getUser_radius ()
    {
        return user_radius;
    }

    public void setUser_radius (String user_radius)
    {
        this.user_radius = user_radius;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getImg ()
    {
        return img;
    }

    public void setImg (String img)
    {
        this.img = img;
    }

    public String getAddress1 ()
    {
        return address1;
    }

    public void setAddress1 (String address1)
    {
        this.address1 = address1;
    }

    public String getAddress2 ()
    {
        return address2;
    }

    public void setAddress2 (String address2)
    {
        this.address2 = address2;
    }

    public String getUser_email ()
    {
        return user_email;
    }

    public void setUser_email (String user_email)
    {
        this.user_email = user_email;
    }

    public String getUser_longitude ()
    {
        return user_longitude;
    }

    public void setUser_longitude (String user_longitude)
    {
        this.user_longitude = user_longitude;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getUser_name ()
    {
        return user_name;
    }

    public void setUser_name (String user_name)
    {
        this.user_name = user_name;
    }

    public String getUser_latitude ()
    {
        return user_latitude;
    }

    public void setUser_latitude (String user_latitude)
    {
        this.user_latitude = user_latitude;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getUser_username ()
    {
        return user_username;
    }

    public void setUser_username (String user_username)
    {
        this.user_username = user_username;
    }

    public String getUser_group_id ()
    {
        return user_group_id;
    }

    public void setUser_group_id (String user_group_id)
    {
        this.user_group_id = user_group_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [phone = "+phone+", user_radius = "+user_radius+", state = "+state+", img = "+img+", address1 = "+address1+", address2 = "+address2+", user_email = "+user_email+", user_longitude = "+user_longitude+", country = "+country+", city = "+city+", user_name = "+user_name+", user_latitude = "+user_latitude+", user_id = "+user_id+", user_username = "+user_username+", user_group_id = "+user_group_id+"]";
    }
}