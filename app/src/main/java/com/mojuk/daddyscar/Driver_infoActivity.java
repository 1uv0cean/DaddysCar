package com.mojuk.daddyscar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class Driver_infoActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_info);
        btn1=findViewById(R.id.no_btn);
        btn2=findViewById(R.id.yes_btn);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }
    public void onClick(View view)
    {
        if(view==btn1) {
            Intent intent = new Intent(this, Recognize_carnoActivity.class);

            startActivity(intent);
        }
        else if (view==btn2) {
            Intent intent = new Intent(this,Nearby_taxiActivity.class);

            startActivity(intent);
        }
    }
}