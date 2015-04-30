package com.example.tchivetta.musicapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class BandList extends ActionBarActivity {

    String[] bandNames;
    int[] images={R.drawable.bib, R.drawable.andsons, R.drawable.smashmouth, R.drawable.florence, R.drawable.wutang};
    ListView list;
    int[] favorites = new int[5];
    int i = 0;
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band_list);

        Resources res = getResources();
        bandNames = res.getStringArray(R.array.bandList);

        list = (ListView) findViewById(R.id.listView);


        customAdapter adapter = new customAdapter(this, bandNames, images);
        list.setAdapter(adapter);
        registerClickCallback();
        registerLongClickCallback();

    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Intent i = new Intent(BandList.this, bandDescription.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
    }//clickregister

    private void registerLongClickCallback(){
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, final long id) {

            setID((int)id);
            AlertDialog.Builder dialogAlert = new AlertDialog.Builder(BandList.this);
            dialogAlert.setTitle("Do you want to add this artist to favorites?");
            dialogAlert.setPositiveButton("Add to Favorites",new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialogInterface, int i) {
                setFavorite();
                }
            });
            dialogAlert.setNegativeButton("Cancel",null);
            dialogAlert.show();
            return false;
            }
        });

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
        if (id == R.id.navigate) {
            //insert intents to call new activity here
            Intent intent;
            intent = new Intent(BandList.this, Concerts.class);
            startActivity(intent);
        }

        if(id == R.id.Favorites){
            Intent intent;
            intent = new Intent(BandList.this,FavoritesList.class);
            intent.putExtra("favorites", getFavorite());
            startActivity(intent);
        }

        if (id == R.id.Uninstall){
            Intent intent;
            intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:com.example.tchivetta.musicapp"));
            startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }

    public void setFavorite(){
        favorites[i] = pos;
        i++;
    }
    public void setID(int id){
        pos = id;
    }
    public int[] getFavorite(){
        return favorites;
    }



}//class

class customAdapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] bandList;

    customAdapter (Context c, String[] bandNames, int img[]){

        super(c,R.layout.bandlistlayout,R.id.textView,bandNames);
        this.context = c;
        this.images = img;
        this.bandList = bandNames;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.bandlistlayout,parent,false);
        ImageView image = (ImageView) row.findViewById(R.id.imageView);
        TextView bandName = (TextView) row.findViewById(R.id.textView);

        image.setImageResource(images[position]);
        bandName.setText(bandList[position]);

        return row;
    }
}
