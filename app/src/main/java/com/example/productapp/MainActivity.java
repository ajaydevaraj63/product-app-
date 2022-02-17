package com.example.productapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
AppCompatButton b1,b2,b3;
dbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);

        dbHelper=new dbHelper(this);
        dbHelper.getReadableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u=new Intent(getApplicationContext(),Addfood.class);
                startActivity(u);
            }
        });
       // b3.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {


        //    }
       // });
    }
}