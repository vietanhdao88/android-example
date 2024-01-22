package com.example.exam2;

import androidx.appcompat.app.AlertDialog;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ListView lv;
    private EditText edtsearch;
    private DBHelper db = new DBHelper(this, "", null, 1);
    private ArrayList<Ticket> arr = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
       // db.Add(new Ticket("Nam Định" , "Hải Phòng" , 500000 , 1));
        arr = db.getAll();

        TicketApdapter ad = new TicketApdapter(MainActivity.this, 1, arr);
        lv.setAdapter(ad);
        Collections.sort(arr, new Comparator<Ticket>() {
            @Override
            public int compare(Ticket ob1, Ticket ob2) {
                return ob1.getGadi().compareToIgnoreCase(ob2.getGadi());
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this , ADD.class);
                startActivity(it);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Ticket selectedItem = arr.get(position);
                String selectedAmount = selectedItem.getGaden();
                 ArrayList<Ticket> arrDelete = new ArrayList<>();
                for (Ticket i : arr) {
                    if(i.getGaden() == selectedAmount){
                        arrDelete.add(i);
                        db.Delete(i);
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle(arrDelete.size());

                    }
                }
                arr.clear();
                arr.addAll(db.getAll());
                ad.notifyDataSetChanged();


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
                ArrayList<Ticket> arrMinus = new ArrayList<>();
                if(edtsearch.length() <= 0){
                    gia = Double.MAX_VALUE;
                }
                else {
                    gia = Double.parseDouble(edtsearch.getText().toString());
                }
                for (Ticket i : arr) {
                    if (i.tinhtien() < gia) {
                        arrMinus.add(i);
                    }
                }
                TicketApdapter ad = new TicketApdapter(MainActivity.this, 1, arrMinus);
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