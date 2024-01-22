package com.example.examfinish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    private EditText edtuten , edtudc , edtusophieu;
    private Button btnupdate , btnuout;
    private DBHelper db = new DBHelper(this , "" , null , 1);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);
        map();
        Intent it = getIntent();
        Restaurant ob = (Restaurant) it.getSerializableExtra("Res");
        edtuten.setText(ob.getTen());
        edtudc.setText(ob.getDc() );
        edtusophieu.setText(ob.getSophieu() + "");


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ob.setTen(edtuten.getText().toString());
                ob.setDc(edtudc.getText().toString());
                ob.setSophieu(Integer.parseInt(edtusophieu.getText().toString()) + 1);
                ob.setDiemtb(ob.tinhdiemtb());
                db.Update(ob);
            }
        });
        btnuout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(UpdateActivity.this , MainActivity.class);
                startActivity(it);
            }
        });

    }
    private void map(){
      edtuten = findViewById(R.id.edtuten);
      edtudc = findViewById(R.id.edtudc);
      edtusophieu = findViewById(R.id.edtusophieu);
      btnuout = findViewById(R.id.btnuout);
      btnupdate = findViewById(R.id.btnupdate);

    }
}
