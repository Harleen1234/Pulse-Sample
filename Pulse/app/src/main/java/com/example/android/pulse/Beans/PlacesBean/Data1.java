package com.example.android.pulse.Beans.PlacesBean;

/**
 * Created by android on 18/12/15.
 */
public class Data1 {

        private AddLocations[] locations;

        public AddLocations[] getLocations ()
        {
            return locations;
        }

        public void setLocations (AddLocations[] locations)
        {
            this.locations = locations;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [locations = "+locations+"]";
        }
    }

