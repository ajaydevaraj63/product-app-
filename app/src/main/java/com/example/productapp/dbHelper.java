package com.example.productapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    static  String dbName="fd.db";
    static  String tblName="foo_table";
    static  String col1="id";
    static  String col2="price";
    static  String col3="pcode";
    static  String col4="pname";

    public dbHelper( Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "create table "+tblName+ "("+col1+" integer primary key autoincrement,"+col2+" text ," +col3+" text ," +col4+" text )";
        db.execSQL(query);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  boolean insert(String price,String code,String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,price);
        cv.put(col3,code);
        cv.put(col4,name);
        long status=db.insert(tblName,null,cv);
        if(status==-1)
        {

            return  false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getdata(String pcode){
        SQLiteDatabase db=this.getWritableDatabase();
        String query= "select * from "+tblName+" where "+col2+ "='"+pcode+"'";
        Cursor c= db.rawQuery(query,null);
      return  c;
    }
}
