package com.example.android.sqlitedemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by user on 18-09-2017.
 */

class CustomAdapter  extends ArrayAdapter{
    SecondActivity sa;
    String[] text;
    public CustomAdapter( SecondActivity sa, String[] text) {
        super(sa,R.layout.customlist,text);
        this.sa=sa;
        this.text=text;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View v, @NonNull ViewGroup parent) {
        LayoutInflater li=sa.getLayoutInflater();
        v=li.inflate(R.layout.customlist,null,false);
        TextView t= (TextView) v.findViewById(R.id.tvlist);
        t.setText(text[position]);
        return v;
    }
}
