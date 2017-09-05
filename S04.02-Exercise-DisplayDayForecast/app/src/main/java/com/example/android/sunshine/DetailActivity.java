package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView mDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mDetails = (TextView) findViewById(R.id.tv_details);

        // TODO (2) Display the weather forecast that was passed from MainActivity
        Intent intentForThis = getIntent();
        if(intentForThis != null){
            if(intentForThis.hasExtra(Intent.EXTRA_TEXT)){
                mDetails.setText(intentForThis.getStringExtra(Intent.EXTRA_TEXT));
            }
        }
    }
}