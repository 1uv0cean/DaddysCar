package com.mojuk.daddyscar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.auth.AuthType;
import com.kakao.auth.Session;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_find_info;

    private Button kakao_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_find_info = findViewById(R.id.txt_find_info);

        kakao_btn = (Button) findViewById(R.id.kakao_btn);

        kakao_btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Session session = Session.getCurrentSession();

                session.addCallback(new SessionCallback());

                session.open(AuthType.KAKAO_LOGIN_ALL, LoginActivity.this);

            }

        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_find_info:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
