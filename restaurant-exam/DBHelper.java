package com.example.examfinish;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_dain";
    public static final String TABLE_NAME = "tblRes";

    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String ADDRESS = "ADDRESS";
    public static final String COUNT ="COUNT";
    public static final String AVERAGE = "AVERAGE";
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
                NAME + " TEXT, " +
                ADDRESS + " TEXT, "+
                COUNT + " integer, " +
                AVERAGE + " double )";
        db.execSQL(query);
    }
    public long Add(Restaurant ob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME , ob.getTen());
        values.put(ADDRESS , ob.getDc() );
        values.put(COUNT , ob.getSophieu() );
        values.put(AVERAGE , ob.getDiemtb() );
        return db.insert(TABLE_NAME , null , values);
    }
    public ArrayList<Restaurant> getAll(){
        ArrayList<Restaurant> arr = new ArrayList<>();
        String query = "Select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query , null);
        if(c.moveToFirst()){
            do{
                Restaurant ob = new Restaurant();

                ob.setMa(c.getInt(0));
                ob.setTen(c.getString(1));
                ob.setDc(c.getString(2));
                ob.setSophieu(c.getInt(3));
                ob.setDiemtb(c.getDouble(4));
                arr.add(ob);
            }while (c.moveToNext());
        }
        return arr;
    }
    public long Delete(Restaurant ob){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME ,  ID + " = ?" , new String[]{String.valueOf(ob.getMa())});
    }
    public long Update(Restaurant ob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID , ob.getMa());
        values.put(NAME , ob.getTen());
        values.put(ADDRESS , ob.getDc() );
        values.put(COUNT , ob.getSophieu() );
        values.put(AVERAGE , ob.getDiemtb() );
        return db.update(TABLE_NAME ,  values , ID + " = ? " , new String[]{String.valueOf(ob.getMa())});

    }
}
