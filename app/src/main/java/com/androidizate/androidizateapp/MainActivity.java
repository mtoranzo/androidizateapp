package com.androidizate.androidizateapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = (TextView) findViewById(R.id.tv_main);

        String mUserName = getIntent().getStringExtra("user_name");
        String mUserMail = getIntent().getStringExtra("user_mail");

        tvMain.setText(String.format(getString(R.string.mensaje_bienvenida), mUserName, mUserMail));
    }
}
