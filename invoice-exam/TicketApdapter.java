package com.example.exam2;

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

public class TicketApdapter extends ArrayAdapter {
    private Context mycontext;
    private ArrayList<Ticket> arr;
    public TicketApdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mycontext=context;
        arr =(ArrayList<Ticket>) objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Ticket pro = arr.get(position);
        View v = convertView;
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=inflater.inflate(R.layout.lvi,null);
        TextView tvga = v.findViewById(R.id.tvga);
        TextView tvdc = v.findViewById(R.id.tvdc);
        TextView tvtb = v.findViewById(R.id.tvtb);
        tvga.setText(pro.getGadi() + "->" + pro.getGaden());
        tvdc.setText(pro.getKhuhoi() == 1 ? "Khứ hồi" : "Một Chiều");
        tvtb.setText(pro.tinhtien() + "");
        return v;
    }
}
