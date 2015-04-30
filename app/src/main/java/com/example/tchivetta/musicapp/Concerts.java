package com.example.tchivetta.musicapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Concerts extends ActionBarActivity implements View.OnClickListener {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concerts);

        TextView title = (TextView) findViewById(R.id.concertTitle);
        TextView location = (TextView) findViewById(R.id.concertVenue);
        TextView desc = (TextView) findViewById(R.id.concertDesc);
        Button call = (Button) findViewById(R.id.callButton);

        title.setText("Breakfast in Bed Concert!");
        location.setText("Location: My Kitchen");
        desc.setText("Phone Number:");
        call.setText("314-867-5309");

        call.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View view){
        try{
            String myNumber = "tel:888-8888";
            Intent callActivity = new Intent(Intent.ACTION_CALL, Uri.parse(myNumber));
            startActivity(callActivity);
        }
        catch(SecurityException e){
            runOnUiThread(new Runnable(){
                public void run() {
                    Toast.makeText(getApplicationContext(), "Cannot call on Emulator",Toast.LENGTH_SHORT).show();
                }
            });

        };
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_concerts, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
