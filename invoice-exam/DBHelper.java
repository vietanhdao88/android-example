package com.example.exam2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_dain";
    public static final String TABLE_NAME = "tblTicket";

    public static final String ID = "ID";
    public static final String GADI = "GADI";
    public static final String GADEN = "GADEN";
    public static final String DONGIA ="DONGIA";
    public static final String KHUHOI = "KHUHOI";
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context , DB_NAME, null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TABLE_NAME);
        onCreate(db);
    }
    public void onCreate(SQLiteDatabase db) {
        String query = "Create Table " + TABLE_NAME + " ( " +

                ID + " integer primary key Autoincrement, "+
                GADI + " TEXT, " +
                GADEN + " TEXT, "+
                DONGIA + " integer, " +
                KHUHOI + " integer )";
        db.execSQL(query);
    }
    public long Add(Ticket ob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GADI , ob.getGadi());
        values.put(GADEN , ob.getGaden() );
        values.put(DONGIA , ob.getDongia() );
        values.put(KHUHOI , ob.getKhuhoi() );
        return db.insert(TABLE_NAME , null , values);
    }
    public ArrayList<Ticket> getAll(){
        ArrayList<Ticket> arr = new ArrayList<>();
        String query = "Select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query , null);
        if(c.moveToFirst()){
            do{
                Ticket ob = new Ticket();

                ob.setMa(c.getInt(0));
                ob.setGadi(c.getString(1));
                ob.setGaden(c.getString(2));
                ob.setDongia(c.getInt(3));
                ob.setKhuhoi(c.getInt(4));
                arr.add(ob);
            }while (c.moveToNext());
        }
        return arr;
    }
    public long Delete(Ticket ob){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME ,  ID + " = ?" , new String[]{String.valueOf(ob.getMa())});
    }
    public long Update(Ticket ob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID , ob.getMa());
        values.put(GADI , ob.getGadi());
        values.put(GADEN , ob.getGaden() );
        values.put(DONGIA , ob.getDongia() );
        values.put(KHUHOI , ob.getKhuhoi() );
        return db.update(TABLE_NAME ,  values , ID + " = ? " , new String[]{String.valueOf(ob.getMa())});

    }
}
