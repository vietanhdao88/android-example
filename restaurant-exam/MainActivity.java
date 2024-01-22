package com.example.examfinish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ListView lv;
    private EditText edtsearch;
    private DBHelper db = new DBHelper(this, "", null, 1);
    private ArrayList<Restaurant> arr = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        arr = db.getAll();

        ResAdapter ad = new ResAdapter(MainActivity.this, 1, arr);
        lv.setAdapter(ad);
        Collections.sort(arr, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                return Double.compare(o2.getDiemtb(), o1.getDiemtb());
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this , AddActivity.class);
                startActivity(it);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this , UpdateActivity.class);
                it.putExtra("Res" ,arr.get(position));
                Bundle bundle = new Bundle();
                it.putExtras(bundle);
                startActivity(it);
                return false;
            }
        });
        edtsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double gia;
                ArrayList<Restaurant> arrMinus = new ArrayList<>();
                if(edtsearch.length() <= 0){
                    gia = Double.MIN_VALUE;
                }
                else {
                    gia = Double.parseDouble(edtsearch.getText().toString());
                }
                for (Restaurant i : arr) {
                    if (i.tinhdiemtb() > gia) {
                        arrMinus.add(i);
                    }
                }
                ResAdapter ad = new ResAdapter(MainActivity.this, 1, arrMinus);
                lv.setAdapter(ad);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void map() {
        edtsearch = findViewById(R.id.edtsearch);
        lv = findViewById(R.id.lv);
        btn = findViewById(R.id.btn);
    }
}