package com.example.zomatoapp.helper;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocationHelper {
    private static final String TAG = LocationHelper.class.getName();

    private LocationManager locationManager;
    private static LocationHelper locationHelper;

    private List<OnLocationChangedListener> listeners = new ArrayList<>();

    private Address address;
    private Location currentLocation = new Location("0.0");

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Address getAddress() {
        return address;
    }

    public static LocationHelper getInstance() {
        if (locationHelper == null) {
            synchronized (LocationHelper.class) {
                if (locationHelper == null) {
                    locationHelper = new LocationHelper();
                }
            }
        }
        return locationHelper;
    }

    public Location getLocation(Context context) {
        String strLocation = "0,0";
        DecimalFormat df = new DecimalFormat("#####0.000000");
        if (!checkPermission(context, PERMISSION.ACCESS_FINE_LOCATION)) {
            Toast.makeText(context, "Please allow to get location information",
                    Toast.LENGTH_SHORT).show();
        }

        try {
            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_FINE);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(false);
            criteria.setPowerRequirement(Criteria.POWER_LOW);
            String provider = locationManager.getBestProvider(criteria, true);

            currentLocation = locationManager.getLastKnownLocation(provider);
            String address = convertAddress(context, currentLocation.getLatitude(), currentLocation.getLongitude());
            Log.d("", "getLocation: address = " + address);

            for (OnLocationChangedListener l : listeners) {
                l.onLocationUpdate(currentLocation);
            }

            if (currentLocation != null) {
                strLocation = df.format(currentLocation.getLatitude()) + "," + df.format(currentLocation.getLongitude());
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currentLocation;
    }

    private final LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            Log.d(TAG, "onLocationChanged: ");
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {

        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };

    public String convertAddress(Context context, double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        StringBuilder stringBuilder = new StringBuilder();

        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (!addresses.isEmpty()) {
                Address address = addresses.get(0);
                this.address = address;
                stringBuilder.append(address.getCountryName()).append(", ").append(address.getAdminArea()).append(", ").append(address.getLocality());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    private boolean checkPermission(Context context, PERMISSION permName) {
        int perm =
                context.checkCallingOrSelfPermission("android.permission." + permName.toString());
        return perm == PackageManager.PERMISSION_GRANTED;
    }

    private enum PERMISSION {
        ACCESS_COARSE_LOCATION,
        ACCESS_FINE_LOCATION
    }

    public interface OnLocationChangedListener {
        void onLocationUpdate(Location location);
    }

    public void registerLocationListener(OnLocationChangedListener l) {
        listeners.add(l);
    }

    public void removeLocationListener(OnLocationChangedListener l) {
        if (!listeners.contains(l)) {
            return;
        }

        listeners.remove(l);
    }
}
