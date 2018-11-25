package com.example.thanh.btktra;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class myarrayAdapter extends ArrayAdapter {
    Activity context = null;
    ArrayList<Item>myArray = null;
    int layoutid;

    public myarrayAdapter(Activity context, int layoutid, ArrayList<Item> myArray) {
        super(context, layoutid, myArray);
        this.context = context;
        this.myArray = myArray;
        this.layoutid = layoutid;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutid, null);
        final Item myitem = myArray.get(position);
        final ImageView btnlike = convertView.findViewById(R.id.btnlike);
        int thich = myitem.getThich();
        if(thich==1) {
            btnlike.setImageResource(R.drawable.like);
        }
        else {
            btnlike.setImageResource(R.drawable.unlike);
        }
        final TextView tieude = convertView.findViewById(R.id.edttenbaihat);
        tieude.setText(myitem.getTieude());
        final TextView maso = convertView.findViewById(R.id.edtmsbaihat);
        maso.setText(myitem.getMaso());
        return convertView;

    }
}
