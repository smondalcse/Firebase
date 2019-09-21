package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayDataActivity extends AppCompatActivity {
    private static final String TAG = "DisplayDataActivity";

    private ListView listview;

    List<StudentModel> studentModelList;
    StudentAdapter studentAdapter;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        listview = findViewById(R.id.listview);
        getData();
    }

    private void getData() {
        Log.d(TAG, "getData: ");

        databaseReference = FirebaseDatabase.getInstance().getReference("students");
        studentModelList = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    StudentModel studentModel = dataSnapshot1.getValue(StudentModel.class);
                    studentModelList.add(studentModel);
                }

                studentAdapter = new StudentAdapter(DisplayDataActivity.this, studentModelList);
                listview.setAdapter(studentAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
