package com.example.productapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Addfood extends AppCompatActivity {
EditText ed1,ed2,ed3;
AppCompatButton b1,B2;
String price,code,name;
dbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfood);
        dbHelper=new dbHelper(this);
        dbHelper.getWritableDatabase();
    b1=findViewById(R.id.add_btn1);
    ed1=findViewById(R.id.ed1);
    ed2=findViewById(R.id.ed2);
    ed3=findViewById(R.id.ed3);
    B2=findViewById(R.id.add_btn2);
    B2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent r=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(r);
        }
    });
     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             price=ed1.getText().toString();
             code=ed2.getText().toString();
             name=ed3.getText().toString();
             boolean result=dbHelper.insert(price,code,name);
             if (result==true)
             {
                 Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
             }
             else {
                 Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
             }
         }
     });
    }
}