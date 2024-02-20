package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    Context context;
    int layout;
    ArrayList<Student> arrayList;

    public StudentAdapter(@NonNull Context context, int resource, ArrayList<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.arrayList = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =LayoutInflater.from(context);
        convertView = inflater.inflate(layout,null);

        ImageView img =(ImageView)convertView.findViewById(R.id.image);
        TextView txt1 = (TextView)convertView.findViewById(R.id.txtName);
        TextView txt2 = (TextView)convertView.findViewById(R.id.txtAddress);

        if(arrayList.get(position).getGender() == 1) {
            img.setImageResource(R.drawable.male);
        }else {
            img.setImageResource(R.drawable.female);
        }

        txt1.setText(arrayList.get(position).getName());
        txt2.setText(arrayList.get(position).getAddress());

        return convertView;

    }
}
