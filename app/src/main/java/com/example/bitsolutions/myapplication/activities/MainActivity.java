package com.example.bitsolutions.myapplication.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bitsolutions.myapplication.R;
import com.example.bitsolutions.myapplication.tools.Logging;
import com.example.bitsolutions.myapplication.activities.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onStart() {
        Logging.v(LOG_TAG, "En el metodo onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Logging.v(LOG_TAG, "En el metodo onResume");
        super.onResume();

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        String locationSaved = sharedPrefs.getString(getString(R.string.pref_location_key), getString(R.string.pref_location_default));

        Toast.makeText(this, locationSaved, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        if (id == R.id.action_logout) {
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }
}
