package com.example.josephbill.twentyfour;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.africastalking.AfricasTalking;
import com.africastalking.models.payment.checkout.CheckoutResponse;
import com.africastalking.models.payment.checkout.MobileCheckoutRequest;
import com.africastalking.services.PaymentService;
import com.africastalking.utils.Callback;
import com.africastalking.utils.Logger;

import java.io.IOException;

public class Shows extends AppCompatActivity {

    PaymentService payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows);

        try {
            //add machines ip address
            //int is the rpcport
            AfricasTalking.initialize("10.42.0.239",35897,true);
            AfricasTalking.setLogger(new Logger() {
                @Override
                public void log(String message, Object... args) {
                    Log.e("ERROR",message);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paybtn (View v){
       new Gigi().execute();
    }
    public class Gigi extends AsyncTask<Void,String,Void>{


        @Override
        protected Void doInBackground(Void... params) {
            try {
                payment = AfricasTalking.getPaymentService();
                //get product name from africastalking sandbox
                MobileCheckoutRequest request = new MobileCheckoutRequest("Twenty", "KES 100", "0734724283");
                payment.checkout(request, new Callback<CheckoutResponse>() {
                    @Override
                    public void onSuccess(CheckoutResponse data) {
                        Toast.makeText(Shows.this,data.status,Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Throwable throwable) {

                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void payjourn (View v){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.josephbill.radah");
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }


    }

}
