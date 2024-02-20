package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ewasteAdapter extends ArrayAdapter<Ewaste> {
    Context context;
    int layout;
    ArrayList<Ewaste> arrayList;


    public ewasteAdapter(@NonNull Context context, int resource, ArrayList<Ewaste> objects){
        super(context,resource,objects);
        this.context = context;
        this.layout = resource;
        this.arrayList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater =LayoutInflater.from(context);
        convertView = inflater.inflate(layout,null);


        TextView tv1 = (TextView)convertView.findViewById(R.id.tv_name);
        TextView tv2 = (TextView)convertView.findViewById(R.id.tv_value);


        tv1.setText(arrayList.get(position).getName());
        tv2.setText(arrayList.get(position).getValue());


        return convertView;
    }


}
