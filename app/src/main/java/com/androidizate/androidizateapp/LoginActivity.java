package com.androidizate.androidizateapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Alumno on 24/07/2017.
 */

public class LoginActivity extends Activity {

    EditText etUserName;
    EditText etUserEmail;
    EditText etUserPassword;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = (EditText) findViewById(R.id.et_user_name);
        etUserEmail = (EditText) findViewById(R.id.et_user_mail);
        etUserPassword = (EditText) findViewById(R.id.et_user_password);
        btLogin = (Button) findViewById(R.id.bt_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validLogin())
                    doLogin();
            }
        });
    }

    private boolean validLogin() {
        if (etUserName.getText().toString().trim().isEmpty()) {
            etUserName.setError(getString(R.string.err_login_usuario));
            return false;
        }
        if (etUserEmail.getText().toString().trim().isEmpty()) {
            etUserEmail.setError(getString(R.string.err_login_email));
            return false;
        }
        if (etUserPassword.getText().toString().trim().isEmpty()) {
            etUserPassword.setError(getString(R.string.err_login_password));
            return false;
        }
        if (etUserPassword.getText().toString().trim() != "1234") {
            etUserPassword.setError(getString(R.string.err_login_password_erroneo));
            return false;
        }
        return true;
    }

    private void doLogin() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("user_name", etUserName.getText());
        intent.putExtra("user_mail", etUserEmail.getText());
        startActivity(intent);
    }
}
