package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    EditText editText;
    ImageView imgface, imgzalo, imggmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Điền tên và đăng nhâp
        button = findViewById(R.id.button);
        editText = findViewById(R.id.username);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);


                Bundle bundle = new Bundle();
              bundle.putString("ten",editText.getText().toString());

               intent.putExtras(bundle);
                startActivity(intent);


            }
        });

        //chat face, zalo, gmail
        imgface= findViewById(R.id.imgface);
        imggmail= findViewById(R.id.imggmail);
        imgzalo= findViewById(R.id.imgzalo);

        imgface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/profile.php?id=100012741031903");
            }
        });
        imgzalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://chat.zalo.me/?null");
            }
        });
        imggmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/intl/vi/gmail/about/");
            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}