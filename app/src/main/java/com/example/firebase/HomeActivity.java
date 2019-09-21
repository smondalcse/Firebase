package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    Button btn_saveImage, btn_saveData, btn_loadData, btn_displayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initWidget();
    }

    private void initWidget() {
        Log.d(TAG, "initWidget: ");

        btn_saveData = findViewById(R.id.btn_saveData);
        btn_saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SaveDataActivity.class);
                startActivity(intent);
            }
        });
        btn_saveImage = findViewById(R.id.btn_saveImage);
        btn_saveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SaveImageActivity.class);
                startActivity(intent);
            }
        });

        btn_loadData = findViewById(R.id.btn_loadData);
        btn_loadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DisplayDataActivity.class);
                startActivity(intent);
            }
        });

        btn_displayImage = findViewById(R.id.btn_displayImage);
        btn_displayImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DisplayImageActivity.class);
                startActivity(intent);
            }
        });

    }
}
