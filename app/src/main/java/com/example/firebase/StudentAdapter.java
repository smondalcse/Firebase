package com.example.firebase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentAdapter extends ArrayAdapter<StudentModel> {

    private Activity context;
    private List<StudentModel> studentList;

    public StudentAdapter(@NonNull Activity context, List<StudentModel> studentList) {
        super(context, R.layout.layout_data, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.layout_data, null, true);
        StudentModel studentModel = studentList.get(position);

        TextView txt_name = view.findViewById(R.id.txt_name_layout);
        TextView txt_age = view.findViewById(R.id.txt_age_layout);

        txt_name.setText(studentModel.getName());
        txt_age.setText(studentModel.getAge());

        return view;
    }



}
