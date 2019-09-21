package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class SaveDataActivity extends AppCompatActivity {
    private static final String TAG = "SaveDataActivity";

  //  Button btn_logout;

    // Write a message to the database
    DatabaseReference databaseReference;

    Button btn_save;
    EditText et_name, et_age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_image);

        initWidget();

        databaseReference = FirebaseDatabase.getInstance().getReference("students");
    }

    private boolean checkValidation() {
        Log.d(TAG, "checkValidation: ");

        String name = et_name.getText().toString().trim();
        String age = et_age.getText().toString().trim();

        if (name.isEmpty()) {
            et_name.setError("Name is required");
            et_name.requestFocus();
            return false;
        }

        if (age.isEmpty()) {
            et_age.setError("Age is required");
            et_age.requestFocus();
            return false;
        }
        return true;
    }

    private void initWidget() {
        Log.d(TAG, "initWidget: ");

        /*
        btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent = new Intent(SaveDataActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        */

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);

        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidation();
                if(checkValidation()) {
                    saveData();
                }
            }
        });


    }

    private void saveData() {
        Log.d(TAG, "saveData: ");

        String name = et_name.getText().toString().trim();
        String age = et_age.getText().toString().trim();

        String key = databaseReference.push().getKey();

        StudentModel studentModel = new StudentModel(name, age);
        databaseReference.child(key).setValue(studentModel);
        Toast.makeText(SaveDataActivity.this, "Student Info is added.",
                Toast.LENGTH_SHORT).show();

    }


}
