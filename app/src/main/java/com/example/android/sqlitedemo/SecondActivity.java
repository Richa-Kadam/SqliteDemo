package com.example.android.sqlitedemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by user on 18-09-2017.
 */

public class SecondActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ListView l= (ListView) findViewById(R.id.lv);
        Bundle b=getIntent().getExtras();
        String val=b.getString("values");
        String text[]={val};
        CustomAdapter ca=new CustomAdapter(SecondActivity.this,text);
        l.setAdapter(ca);

    }
}