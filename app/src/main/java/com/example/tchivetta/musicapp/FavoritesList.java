package com.example.tchivetta.musicapp;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class FavoritesList extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int[] favorites;
        favorites = getIntent().getExtras().getIntArray("favorites");
        setContentView(R.layout.activity_favorites_list);
        TextView FavA = (TextView) findViewById(R.id.fav1);
        TextView FavB = (TextView) findViewById(R.id.fav2);
        TextView FavC = (TextView) findViewById(R.id.fav3);
        TextView FavD = (TextView) findViewById(R.id.fav4);
        TextView FavE = (TextView) findViewById(R.id.fav5);
        TextView title = (TextView) findViewById(R.id.favoritesTitle);
        title.setText("Favorites");

        Resources res = getResources();
        String[] bandNames = res.getStringArray(R.array.bandList);

        FavA.setText(bandNames[favorites[0]]);
        FavB.setText(bandNames[favorites[1]]);
        FavC.setText(bandNames[favorites[2]]);
        FavD.setText(bandNames[favorites[3]]);
        FavE.setText(bandNames[favorites[4]]);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_favorites_list, menu);
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
