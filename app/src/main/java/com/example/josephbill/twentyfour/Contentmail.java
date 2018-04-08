package com.example.josephbill.twentyfour;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.josephbill.twentyfour.Adapter.FeedAdapter;
import com.example.josephbill.twentyfour.Common.HTTPDataHandler;
import com.example.josephbill.twentyfour.model.Rssobject;
import com.google.gson.Gson;

/**
 * Created by Joseph Bill on 2/9/2018.
 */

public class Contentmail extends AppCompatActivity {

     Toolbar toolbar;
    RecyclerView recyclerView;
    Rssobject rssobject;

    //rss link'
    private final String Rss_link = "http://www/google.com";
    //here add the url api address from your rss to json converter
    private final String Rss_to_Json_API = "http://musicfeeds.com.au/feeds/mtv/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("TwentyFour");
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        loadRss();
    }

    private void loadRss() {
        AsyncTask<String,String,String> loadRssAsync = new AsyncTask<String, String, String>() {
            ProgressDialog mDialog = new ProgressDialog(Contentmail.this);

            @Override
            protected void onPreExecute(){
                mDialog.setMessage("please wait ... ");
                mDialog.show();
            }
            @Override
            protected String doInBackground(String... params) {
             String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.getHTTPData(params[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s){

                mDialog.dismiss();
                //converting rss feed to json using Gson
                rssobject = new Gson().fromJson(s,Rssobject.class);
                FeedAdapter adapter = new FeedAdapter(rssobject , getBaseContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };

        StringBuilder url_get_data = new StringBuilder(Rss_to_Json_API);
        url_get_data.append(Rss_link);
        loadRssAsync.execute(url_get_data.toString());
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh)
            loadRss();
        return true;
    }
}
