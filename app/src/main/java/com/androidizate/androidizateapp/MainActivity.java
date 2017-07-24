package com.androidizate.androidizateapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvMain;
    Button btEMail;
    String mUserName;
    String mUserMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = (TextView) findViewById(R.id.tv_main);

        mUserName = getIntent().getStringExtra("user_name");
        mUserMail = getIntent().getStringExtra("user_mail");

        tvMain.setText(String.format(getString(R.string.mensaje_bienvenida), mUserName, mUserMail));

        btEMail = (Button)findViewById(R.id.bt_email);
        btEMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    private void sendEmail(){
        String[] mEmails = new String[] {mUserMail, "info@info.com"};
        String mSubject = "Saludo desde androidizate";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, mEmails);
        intent.putExtra(Intent.EXTRA_SUBJECT, mSubject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
