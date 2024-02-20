package com.example.app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.Ewaste;
import com.example.app.ewasteHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
   View mView;
   TextView tv_view;
   Button btn_check;
   RadioButton rb1a, rb1b, rb1c, rb2a, rb2c, rb2b, rb3a, rb3b, rb3c, rb4a, rb4b, rb4c, rb5a, rb5b,rb5c, rb6a,rb6b,rb6c,rb7a,rb7b,rb7c;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        rb1a = mView.findViewById(R.id.rb1a);
        rb1b = mView.findViewById(R.id.rb1b);
        rb1c = mView.findViewById(R.id.rb1c);
        rb2a = mView.findViewById(R.id.rb2a);
        rb2b = mView.findViewById(R.id.rb2b);
        rb2c = mView.findViewById(R.id.rb2c);
        rb3a = mView.findViewById(R.id.rb3a);
        rb3b = mView.findViewById(R.id.rb3b);
        rb3c = mView.findViewById(R.id.rb3c);
        rb4a = mView.findViewById(R.id.rb4a);
        rb4b = mView.findViewById(R.id.rb4b);
        rb4c = mView.findViewById(R.id.rb4c);
        rb5a = mView.findViewById(R.id.rb5a);
        rb5b = mView.findViewById(R.id.rb5b);
        rb5c = mView.findViewById(R.id.rb5c);
        rb6a = mView.findViewById(R.id.rb6a);
        rb6b = mView.findViewById(R.id.rb6b);
        rb6c = mView.findViewById(R.id.rb6c);
        rb7a = mView.findViewById(R.id.rb7a);
        rb7b = mView.findViewById(R.id.rb7b);
        rb7c = mView.findViewById(R.id.rb7c);

        tv_view = mView.findViewById(R.id.tv_view);
        btn_check = mView.findViewById(R.id.btn_result);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb1a.isChecked() && rb2a.isChecked() && rb3a.isChecked() ){
                    tv_view.setText("In 1 year you consume 227.6kg of e-waste");
                }
                else if(rb1a.isChecked() && rb2a.isChecked() && rb3b.isChecked()){
                    tv_view.setText("In 1 year you consume 230.2kg of e-waste");
                }
                else if(rb1a.isChecked() && rb2a.isChecked() && rb3c.isChecked() ){
                    tv_view.setText("In 1 year you consume 231.5kg of e-waste");
                }
                else if(rb1a.isChecked() && rb2b.isChecked() && rb3a.isChecked() ){
                    tv_view.setText("In 1 year you consume 230.2kg of e-waste");
                }
                else if(rb1a.isChecked() && rb2b.isChecked() && rb3b.isChecked() ){
                    tv_view.setText("In 1 year you consume 230.2kg of e-waste");
                }
                else if(rb1a.isChecked() && rb2b.isChecked() && rb3c.isChecked() ){
                    tv_view.setText("In 1 year you consume 230.2kg of e-waste");
                }
                else if(rb1a.isChecked() && rb2c.isChecked() && rb3a.isChecked() ){
                    tv_view.setText("In 1 year you consume 230.2kg of e-waste");
                }
                else if(rb1a.isChecked() && rb2c.isChecked() && rb3b.isChecked() ){
                    tv_view.setText("In 1 year you consume 230.2kg of e-waste");
                }
                else if(rb1a.isChecked() && rb2c.isChecked() && rb3c.isChecked() ){
                    tv_view.setText("In 1 year you consume 230.2kg of e-waste");
                }
                //not
                else if(rb1b.isChecked() && rb2a.isChecked() && rb3a.isChecked() ){
                    tv_view.setText("In 1 year you consume 240.6kg of e-waste");
                }
                else if(rb1b.isChecked() && rb2a.isChecked() && rb3b.isChecked()){
                    tv_view.setText("In 1 year you consume 250.2kg of e-waste");
                }
                else if(rb1b.isChecked() && rb2a.isChecked() && rb3c.isChecked() ){
                    tv_view.setText("In 1 year you consume 237.5kg of e-waste");
                }
                else if(rb1b.isChecked() && rb2b.isChecked() && rb3a.isChecked() ){
                    tv_view.setText("In 1 year you consume 290.2kg of e-waste");
                }
                else if(rb1b.isChecked() && rb2b.isChecked() && rb3b.isChecked() ){
                    tv_view.setText("In 1 year you consume 430.2kg of e-waste");
                }
                else if(rb1b.isChecked() && rb2b.isChecked() && rb3c.isChecked() ){
                    tv_view.setText("In 1 year you consume 630.2kg of e-waste");
                }
                else if(rb1b.isChecked() && rb2c.isChecked() && rb3a.isChecked() ){
                    tv_view.setText("In 1 year you consume 530.2kg of e-waste");
                }
                else if(rb1b.isChecked() && rb2c.isChecked() && rb3b.isChecked() ){
                    tv_view.setText("In 1 year you consume 330.2kg of e-waste");
                }
                else if(rb1b.isChecked() && rb2c.isChecked() && rb3c.isChecked() ){
                    tv_view.setText("In 1 year you consume 530.2kg of e-waste");
                }
                //not
                else if(rb1c.isChecked() && rb2a.isChecked() && rb3a.isChecked() ){
                    tv_view.setText("In 1 year you consume 457.6kg of e-waste");
                }
                else if(rb1c.isChecked() && rb2a.isChecked() && rb3b.isChecked()){
                    tv_view.setText("In 1 year you consume 580.2kg of e-waste");
                }
                else if(rb1c.isChecked() && rb2a.isChecked() && rb3c.isChecked() ){
                    tv_view.setText("In 1 year you consume 431.5kg of e-waste");
                }
                else if(rb1c.isChecked() && rb2b.isChecked() && rb3a.isChecked() ){
                    tv_view.setText("In 1 year you consume 430.2kg of e-waste");
                }
                else if(rb1c.isChecked() && rb2b.isChecked() && rb3b.isChecked() ){
                    tv_view.setText("In 1 year you consume 530.2kg of e-waste");
                }
                else if(rb1c.isChecked() && rb2b.isChecked() && rb3c.isChecked() ){
                    tv_view.setText("In 1 year you consume 530.2kg of e-waste");
                }
                else if(rb1c.isChecked() && rb2c.isChecked() && rb3a.isChecked() ){
                    tv_view.setText("In 1 year you consume 430.2kg of e-waste");
                }
                else if(rb1c.isChecked() && rb2c.isChecked() && rb3b.isChecked() ){
                    tv_view.setText("In 1 year you consume 730.2kg of e-waste");
                }
                else if(rb1c.isChecked() && rb2c.isChecked() && rb3c.isChecked() ){
                    tv_view.setText("In 1 year you consume 633.2kg of e-waste");
                }



            }
        });







        return mView;
    }
}
//         Toast.makeText(getActivity().getApplicationContext() ,
//                "id: "+arrayList.get(0).getName() ,
//                Toast.LENGTH_LONG).show();
