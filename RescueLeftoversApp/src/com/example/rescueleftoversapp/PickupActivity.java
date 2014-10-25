package com.example.rescueleftoversapp;

import java.util.HashMap;
import java.util.Random;

import android.content.Intent;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PickupActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HashMap<String, String> addresses = new HashMap();
        addresses.put("Bobby Van\'s Steakhouse", "230 Park Avenue, New York, NY 10169");
        addresses.put("Jiannetto\'s Pizza and Catering", "47 St Park Ave, Manhattan, NY 10017");
        addresses.put("Chipotle Mexican Grill", "320 Park Avenue, New York, NY 10022");
        addresses.put("Cosi", "38 E 45th Street, New York, NY 10017");
        addresses.put("Pret A Manger", "425 Madison, New York, NY 10017");
        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MapActivity.EXTRA_MESSAGE);

        String endTime = message.substring(message.length() - 7, message.length());
        String startTime = message.substring(message.length() - 15, message.length() - 8);
        String date = message.substring(message.length() - 32, message.length() - 16);
        String name = message.substring(0, message.length() - 32);
        setTitle(name);
        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(20);
        Random rand = new Random();
        String s = String.format("Name: %s %nAddress: %s %nDate: %s %nStart Time: %s %nEnd Time: %s %nTotal Weight: %d %nAvailable slots: %d", 
                                 name + intent.getStringExtra(MapActivity.CURRENT_MARKER), addresses.get(name), date, startTime, endTime, (rand.nextInt(6) + 5) * 10, name.length() % 3);
        textView.setText(s);

        // Set the text view as the activity layout
        setContentView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pickup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_pickup,
                    container, false);
            return rootView;
        }
    }
}
