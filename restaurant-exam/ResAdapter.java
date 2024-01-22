package com.example.examfinish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ResAdapter extends ArrayAdapter {
    private Context mycontext;
    private ArrayList<Restaurant> arr;
    public ResAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mycontext=context;
        arr =(ArrayList<Restaurant>) objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Restaurant pro = arr.get(position);
        View v = convertView;
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=inflater.inflate(R.layout.liv,null);
        TextView tvten = v.findViewById(R.id.tvten);
        TextView tvdc = v.findViewById(R.id.tvdc);
        TextView tvtb = v.findViewById(R.id.tvtb);
        tvten.setText(pro.getTen() + "");
        tvdc.setText(pro.getDc());
        tvtb.setText(pro.tinhdiemtb() + "");
        return v;
    }
}
