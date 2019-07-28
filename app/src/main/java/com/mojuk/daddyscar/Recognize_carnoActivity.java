package com.mojuk.daddyscar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Recognize_carnoActivity extends AppCompatActivity  implements View.OnClickListener {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognize_carno);
        btn1=findViewById(R.id.CP_btn);
        btn1.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if(view==btn1) {
            Intent intent = new Intent(this, Inside_taxiActivity.class);

            startActivity(intent);
        }
    }
}
