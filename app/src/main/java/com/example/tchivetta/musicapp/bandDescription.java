package com.example.tchivetta.musicapp;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class bandDescription extends ActionBarActivity {

    String[] bandNames;
    String[] bandDesc;
    int[] images={R.drawable.bib, R.drawable.andsons, R.drawable.smashmouth, R.drawable.florence, R.drawable.wutang};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band_description);

        TextView bandName = (TextView) findViewById(R.id.textView2);
        TextView bandDescription = (TextView) findViewById(R.id.textView3);
        ImageView bandPic = (ImageView) findViewById(R.id.imageView2);
        int pos = getIntent().getExtras().getInt("position");

        Resources res = getResources();
        bandNames = res.getStringArray(R.array.bandList);
        bandDesc = res.getStringArray(R.array.bandDesc);

        bandName.setText(bandNames[pos]);
        bandDescription.setText(bandDesc[pos]);
        bandPic.setImageResource(images[pos]);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_band_description, menu);
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
