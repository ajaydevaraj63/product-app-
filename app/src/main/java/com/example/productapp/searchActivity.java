package com.example.productapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class searchActivity extends AppCompatActivity {
AppCompatButton b1;
EditText ed1,ed2,ed3;
dbHelper Dbhelper;
String pcode,pname,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
      b1=findViewById(R.id.search_add_btn1);
      ed1=findViewById(R.id.search_ed1);
        ed2=findViewById(R.id.search_ed2);
        ed3=findViewById(R.id.search_ed3);
        Dbhelper=new dbHelper(this);
        Dbhelper.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pcode=ed1.getText().toString();
                Cursor c=Dbhelper.getdata(pcode);

                    if(c.getCount()==0){
                        //invalid
                    }
                    else{
                        while(c.moveToNext()){
                        pname=c.getString(3);
                        price=c.getString(2);
                        }
                        ed2.setText(pname);
                        ed2.setText(price);
                    }

                }

        });




    }
}