package com.example.examfinish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private EditText edtten , edtdc , edtdiem , edtsophieu;
    private Button btnadd , btnout;
    private DBHelper db = new DBHelper(this , "" , null , 1);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        map();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restaurant ob = new Restaurant();
                ob.setTen(edtten.getText().toString());
                ob.setDc(edtdc.getText().toString());
                ob.setSophieu(1);
                ob.setDiemtb(ob.tinhdiemtb());
                db.Add(ob);
            }
        });
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(AddActivity.this , MainActivity.class);
                startActivity(it);
            }
        });
    }
    private void map(){
        edtten = findViewById(R.id.edtten);
        edtdc = findViewById(R.id.edtdiachi);
        edtsophieu = findViewById(R.id.edtsophieu);

        btnadd = findViewById(R.id.btnupdate);
        btnout = findViewById(R.id.btnuout);
    }
}
