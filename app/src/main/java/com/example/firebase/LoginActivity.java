package com.example.firebase;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private EditText et_email, et_password;
    private Button btn_signin;
    private TextView txt_registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initWidget();
    }

    private void initWidget() {
        Log.d(TAG, "initWidget: ");

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        btn_signin = findViewById(R.id.btn_signin);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkValidation()){
                    loginUser();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        txt_registration = findViewById(R.id.txt_registration);
        txt_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkValidation() {
        Log.d(TAG, "checkValidation: ");

        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        if (email.isEmpty()) {
            et_email.setError("Email is required");
            et_email.requestFocus();
            return false;
        }

        if (password.isEmpty()) {
            et_password.setError("Password is required");
            et_password.requestFocus();
            return false;
        }
        return true;
    }

    private void loginUser() {
        Log.d(TAG, "loginUser: ");



    }
}
