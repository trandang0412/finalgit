package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ListView listView;
    ArrayList<Student> arrayList;
    StudentAdapter studentAdapter;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //khoi tao doi tuong DBHelper
        db = new DBHelper(MainActivity3.this);
        //mapping listview
        listView = findViewById(R.id.list);
        //load danh sach sinh vien
        arrayList = db.getAllStudent();
        studentAdapter = new StudentAdapter(MainActivity3.this,
                R.layout.layout_row,
                arrayList);

        listView.setAdapter(studentAdapter);

        //dang ky menu COntext cho listView
        registerForContextMenu(listView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mnu_add){
            final Student student = new Student();

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);

            builder.setTitle("Insert your bonus");
            builder.setCancelable(false);

            LayoutInflater inflater = LayoutInflater.from(MainActivity3.this);
            View view = inflater.inflate(R.layout.layout_input,null);

            final EditText edtName = view.findViewById(R.id.edtName);
            final EditText edtAddress = view.findViewById(R.id.edtAddress);
            final RadioGroup rdg = view.findViewById(R.id.rdgGender);
            final ImageView img = view.findViewById(R.id.image);

            builder.setView(view);

            rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    switch (i){
                        case R.id.rdbMale:
                            student.setGender(1);
                            img.setImageResource(R.drawable.male);
                            break;
                        case R.id.rdbFemale:
                            student.setGender(0);
                            img.setImageResource(R.drawable.female);
                            break;
                    }

                }
            });


            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    student.setName(edtName.getText().toString());
                    student.setAddress(edtAddress.getText().toString());

                    db.insertStudent(student);
                    arrayList.add(student);
                    studentAdapter.notifyDataSetChanged();
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });



            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.mnu_update:
                final Student student = arrayList.get(info.position);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);

                builder.setTitle("Update student");
                builder.setCancelable(false);

                LayoutInflater inflater = LayoutInflater.from(MainActivity3.this);
                View view = inflater.inflate(R.layout.layout_input,null);

                final EditText edtName = view.findViewById(R.id.edtName);
                final EditText edtAddress = view.findViewById(R.id.edtAddress);
                final RadioGroup rdg = view.findViewById(R.id.rdgGender);
                final RadioButton rdbMale = view.findViewById(R.id.rdbMale);
                final RadioButton rdbFemale = view.findViewById(R.id.rdbFemale);
                final ImageView img = view.findViewById(R.id.image);

                edtName.setText(student.getName());
                edtAddress.setText(student.getAddress());

                if(student.getGender() == 1){
                    rdbMale.setChecked(true);
                    img.setImageResource(R.drawable.male);
                }else {
                    rdbFemale.setChecked(true);
                    img.setImageResource(R.drawable.female);
                }


                builder.setView(view);

                rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.rdbMale:
                                student.setGender(1);
                                img.setImageResource(R.drawable.male);
                                break;
                            case R.id.rdbFemale:
                                student.setGender(0);
                                img.setImageResource(R.drawable.female);
                                break;
                        }

                    }
                });

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        student.setName(edtName.getText().toString());
                        student.setAddress(edtAddress.getText().toString());

                        db.updateStudent(student);
                        arrayList.set(info.position,student);
                        studentAdapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });



                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
            case R.id.mnu_delete:
                final Student student1 = arrayList.get(info.position);

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity3.this);

                builder1.setTitle("Delete student");
                builder1.setCancelable(false);
                builder1.setMessage("Are you sure delete \" " + student1.getName() + "\"" );

                builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.deleteStudent(student1);
                        arrayList.remove(info.position);
                        studentAdapter.notifyDataSetChanged();
                    }
                });

                builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog1 = builder1.create();
                alertDialog1.show();


                break;

        }

        return super.onContextItemSelected(item);
    }

}