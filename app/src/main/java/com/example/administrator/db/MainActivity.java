package com.example.administrator.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
   private ListView mListView;
    private SimpleCursorAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHelper myDBHelper=new MyDBHelper(this,"data",2);
//        SQLiteDatabase dbWrite=myDBHelper.getWritableDatabase();
//        ContentValues cv=new ContentValues();
//        cv.put("name","zhangsan");
//        cv.put("phone","13588830380");
//        dbWrite.insert("user",null,cv);
//
//        cv=new ContentValues();
//        cv.put("name","lisi");
//        cv.put("phone","13858120073");
//        dbWrite.insert("user",null,cv);
//
//        dbWrite.close();
        SQLiteDatabase dbreader=myDBHelper.getReadableDatabase();
        Cursor c=dbreader.query("user",null,null,null,null,null,null);
        mAdapter=new SimpleCursorAdapter(this,R.layout.list_item,c,new String[]{"name"},new int[]{R.id.tv_name});
        mListView.setAdapter(mAdapter);
        while (c.moveToNext()){
            String name=c.getString(c.getColumnIndex("name"));
            String phone=c.getString(c.getColumnIndex("phone"));
            Log.d("lsx", "name:" + name + "|phone:" + phone);
        }
        if(c!=null) c.close();
        if(dbreader!=null) dbreader.close();
    }


}
