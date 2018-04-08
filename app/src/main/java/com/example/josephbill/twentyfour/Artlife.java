package com.example.josephbill.twentyfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Artlife extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artlife);
    }

    public void entbutton (View v){
        Intent intent = new Intent(this, Artist.class);
        startActivity(intent);

    }
}
