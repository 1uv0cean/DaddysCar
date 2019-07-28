package com.mojuk.daddyscar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Review_writeActivity extends AppCompatActivity  implements View.OnClickListener {
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_write);
        btn1 = findViewById(R.id.nob_button);
        btn2 = findViewById(R.id.write_button);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    public void onClick(View view) {
        if (view == btn1) {
            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);
        } else if (view == btn2) {
            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);
        }
    }
}
