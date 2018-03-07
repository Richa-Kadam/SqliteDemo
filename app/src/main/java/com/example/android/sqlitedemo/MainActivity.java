package com.example.android.sqlitedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText name, email, city;
    Button add, show;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("db_details", Context.MODE_PRIVATE, null);
        db.execSQL("create table if not exists Details(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,name varchar,email varchar,city varchar);");
        name = (EditText) findViewById(R.id.etname);
        email = (EditText) findViewById(R.id.etemail);
        city = (EditText) findViewById(R.id.etcity);
        add = (Button) findViewById(R.id.add);
        show = (Button) findViewById(R.id.show);

    }

    public void onAdd(View v) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || city.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Fill all Details", Toast.LENGTH_SHORT).show();
        } else if (!email.getText().toString().matches(emailPattern)) {
            email.setError("Enter valid email id");
        } else {
            db.execSQL("Insert into Details(name,email,city) values('" + name.getText().toString() + "','" + email.getText().toString() + "','" + city.getText().toString() + "');");
            Toast.makeText(MainActivity.this, "Values Inserted", Toast.LENGTH_SHORT).show();
            name.setText("");
            email.setText("");
            city.setText("");
        }
    }

    public void onShow(View v) {

        Cursor c = db.rawQuery("Select * from Details", null);
        StringBuffer sb = new StringBuffer();
        while (c.moveToNext()) {
            sb.append("Id:" + c.getString(0) + "\n");
            sb.append("Name:" + c.getString(1) + "\n");
            sb.append("Email:" + c.getString(2) + "\n");
            sb.append("City:" + c.getString(3) + "\n");
        }
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("values", sb.toString());
        startActivity(i);
    }
}
