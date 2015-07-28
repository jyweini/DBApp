package com.example.administrator.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHelper myDBHelper=new MyDBHelper(this,"data",2);
        SQLiteDatabase dbWrite=myDBHelper.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name","zhangsan");
        cv.put("phone","13588830380");
        dbWrite.insert("user",null,cv);

        cv=new ContentValues();
        cv.put("name","lisi");
        cv.put("phone","13858120073");
        dbWrite.insert("user",null,cv);

        dbWrite.close();
    }


}
