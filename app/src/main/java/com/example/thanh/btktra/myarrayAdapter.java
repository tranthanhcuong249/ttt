package com.example.thanh.btktra;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class myarrayAdapter extends ArrayAdapter<Item> {
    Activity context = null;
    ArrayList<Item>myArray = null;
    int layoutid;

    public myarrayAdapter(Activity context, int layoutid, ArrayList<Item> arr) {
        super(context, layoutid, arr);
        this.context = context;
        this.myArray = arr;
        this.layoutid = layoutid;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        final LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutid, null);
        final Item myItem = myArray.get(position);
        final TextView tieude = convertView.findViewById(R.id.txttieude);
        tieude.setText(myItem.getTieude());
        final TextView maso = convertView.findViewById(R.id.txtmaso);
        maso.setText(myItem.getMaso());
        final ImageButton btnlike = convertView.findViewById(R.id.btnlike);
        final ImageButton btnunlike = convertView.findViewById(R.id.btnunlike);
        int thich = myItem.getThich();
        if(thich==0) {
            btnlike.setVisibility(View.INVISIBLE);
            btnunlike.setVisibility(View.VISIBLE);
        }
        else {
            btnunlike.setVisibility(View.INVISIBLE);
            btnlike.setVisibility(View.VISIBLE);
        }
        btnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH",0);
                MainActivity.database.update("ArirangSongList", values, "MABH=?" , new
                String[]{maso.getText().toString()});
                btnlike.setVisibility(View.INVISIBLE);
                btnunlike.setVisibility(View.VISIBLE);
            }
        });
        btnunlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH",1);
                MainActivity.database.update("ArirangSongList", values, "MABH=?" , new
                        String[]{maso.getText().toString()});
                btnunlike.setVisibility(View.INVISIBLE);
                btnlike.setVisibility(View.VISIBLE);
            }
        });
        tieude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tieude.setTextColor(Color.RED);
                maso.setTextColor(Color.RED);
                Intent intent1 = new Intent(context,activitysub.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("maso", maso.getText().toString());
                intent1.putExtra("pakage", bundle1);
                context.startActivity(intent1);
            }
        });
        return convertView;
    }
}
