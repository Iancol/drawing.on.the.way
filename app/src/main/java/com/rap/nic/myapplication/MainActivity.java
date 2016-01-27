package com.rap.nic.myapplication;

// make these classes available
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazon.device.ads.AdRegistration;
import com.bumptech.glide.Glide;
import com.rap.nic.draw.R;

import java.io.File;

// extend Activity class
public class MainActivity extends Activity {

    private WebView webView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        AdRegistration.setAppKey("8e4492d6f2e24a7e92ac2864414f2f7b");
        // make app full screen on device
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_main);




        // set webView to the webView on activity_main.xml
        // by its id
        webView = (WebView) findViewById(R.id.webView);
        // enable javascript which is essential for slick
        //WP responsive designs
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setBuiltInZoomControls(true);
        // load any web url you like
        webView.loadUrl("http://www.rapuano.eu/");
        // this makes sure that when links are clicked the user
        // stays in the app
        webView.setWebViewClient(new WebViewClient());

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        switch(id)
        {

            case R.id.MENU_01:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "http://www.rapuano.eu/_app/drawing.apk");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Share app"));



                break;
            case R.id.MENU_0:
                Intent sendIntent1 = new Intent();
                sendIntent1.setAction(Intent.ACTION_SEND);
                sendIntent1.putExtra(Intent.EXTRA_TEXT, "http://www.rapuano.eu/atomi/Escher%20pesci%20e%20squame%40500.jpg");
                sendIntent1.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent1, "Share img"));



                break;
            case R.id.MENU_2:
            /*
                About


             */
                // definisco l'intenzione
                Intent openPage1 = new Intent(MainActivity.this,about.class);
                // passo all'attivazione dell'activity Pagina.java
                startActivity(openPage1);

                break;
            case R.id.MENU_1:

                //set up dialog
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.activity_my_dialog);
                dialog.setTitle("This is my custom dialog box");
                dialog.setCancelable(true);
                //there are a lot of settings, for dialog, check them all out!

                //set up text
                TextView text = (TextView) dialog.findViewById(R.id.TextView01);
                text.setText(R.string.arap);


                //set up image view
                ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);

                Glide.with(this)
                        .load("http://www.rapuano.eu/atomi/Escher pesci e squame@500.jpg")
                        .into(img);
                //img.setImageResource(R.drawable.nista_logo);

                //set up button
                Button button = (Button) dialog.findViewById(R.id.Button01);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       finish();
                    }
                });
                //now that the dialog is set up, it's time to show it
                dialog.show();

                break;
            case R.id.MENU_3:

                this.finish();
                break;
        }
        return false;
    }

}
