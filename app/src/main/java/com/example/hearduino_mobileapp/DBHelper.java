package com.example.hearduino_mobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DENAME = "Account.db"; //name of the database

    public DBHelper(Context context) {
        super(context, "Account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create Table users(name TEXT primary key, email TEXT primary key, number TEXT primary key, passcode TEXT primary key, relation TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int i, int i1) {
        myDatabase.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String name, String email, String number, String passcode, String relation){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Email", email);
        contentValues.put("Number", number);
        contentValues.put("Code", passcode);
        contentValues.put("Relation", relation);
        long result = myDatabase.insert("account", null, contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkName(String name){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where name = ?", new String[] {name});
        if(cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkNameEmail(String name, String email){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where name = ? and email = ?", new String[] {name,email});
        if(cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }
}