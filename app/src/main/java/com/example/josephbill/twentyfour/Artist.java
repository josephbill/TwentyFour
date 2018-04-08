package com.example.josephbill.twentyfour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Artist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
    }

    public void shows (View v){
        Intent intent = new Intent(this,Shows.class);
        startActivity(intent);


    }
    public void music (View view){
        goToUrl ("http://www.mdundo.com/");
    }
    public void vid (View view){
        goToUrl("http://www.youtube.com");
    }


    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
