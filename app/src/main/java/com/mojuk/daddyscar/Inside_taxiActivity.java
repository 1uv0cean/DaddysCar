package com.mojuk.daddyscar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Inside_taxiActivity extends AppCompatActivity  implements View.OnClickListener {
    Button btn1;
    Button btn2;
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_taxi);
        btn1=findViewById(R.id.emergency_btn);
        btn2=findViewById(R.id.info_btn);
        btn3=findViewById(R.id.quit_btn);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if(view==btn1) {
            Intent intent = new Intent(this, Illegal_taxiActivity.class);

            startActivity(intent);
        }
        else if (view==btn2) {
            Intent intent = new Intent(this, Taxi_info_sendActivity.class);

            startActivity(intent);
        }
        else if (view==btn3) {
            Intent intent = new Intent(this, Review_writeActivity.class);

            startActivity(intent);
        }
    }
}
