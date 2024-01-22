package com.example.exam2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ADD extends AppCompatActivity {
    private EditText edtgadi , edtgaden , edtdongia ;
    private Button btnadd , btnout;
    private RadioButton ra1 , ra0;
    private DBHelper db = new DBHelper(this , "" , null , 1);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        map();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ticket ob = new Ticket();
                ob.setGadi(edtgadi.getText().toString());
                ob.setGaden(edtgaden.getText().toString());
                ob.setDongia( Integer.parseInt(edtdongia.getText().toString() ));
                ob.setKhuhoi(ra1.isChecked() ? 1 : 0);
                db.Add(ob);
            }
        });
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ADD.this , MainActivity.class);
                startActivity(it);
            }
        });
    }
    private void map(){
        edtgadi = findViewById(R.id.edtugaden);
        edtgaden = findViewById(R.id.edtugaden);
        edtdongia = findViewById(R.id.edtudongia);
        ra1 = findViewById(R.id.rau1);
        ra0 = findViewById(R.id.rau0);
        btnadd = findViewById(R.id.btnthem);
        btnout = findViewById(R.id.btnuout);
    }
}
