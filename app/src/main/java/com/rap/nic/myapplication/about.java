package com.rap.nic.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.net.Uri;

import com.bumptech.glide.Glide;
import com.rap.nic.draw.R;


import android.support.v7.app.AppCompatActivity;






public class about extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Gestione di immagini remote");

        ImageView image1= (ImageView) findViewById(R.id.image_sport);
        ImageView image2= (ImageView) findViewById(R.id.image_natura);
        ImageView image3= (ImageView) findViewById(R.id.image_cibo);

        Glide.with(this)
                .load("http://www.rapuano.eu/atomi/Escher pesci e squame@500.jpg")
                .into(image1);

        Glide.with(this)
                .load("http://lorempixel.com/500/400/nature")
                .into(image2);

        Glide.with(this)
                .load("http://lorempixel.com/500/400/food")
                .into(image3);

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.MENU_1:
            /*
               twitter
             */

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://twitter.com/nicrap/"));
                startActivity(intent);
                break;
            case R.id.MENU_2:

               Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.addCategory(Intent.CATEGORY_BROWSABLE);
                intent1.setData(Uri.parse("https://www.facebook.com/nicola.rapuano"));
                startActivity(intent1);


                break;
            case R.id.MENU_3:
                // definisco l'intenzione
              this.finish();
                break;
        }
        return false;
    }


}









