package com.mojuk.daddyscar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class Taxi_info_sendActivity extends AppCompatActivity  implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi_info_send);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
