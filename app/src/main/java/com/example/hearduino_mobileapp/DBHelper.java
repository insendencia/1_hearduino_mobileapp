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
        myDatabase.execSQL("create Table users(name TEXT primary key, username TEXT primary key, code TEXT primary key, relation TEXT primary key, hrCode TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int i, int i1) {
        myDatabase.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String name, String username, String code, String relation, String hrCode){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Username", username);
        contentValues.put("Code", code);
        contentValues.put("Relation", relation);
        contentValues.put("HRCode", hrCode);
        long result = myDatabase.insert("account", null, contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkUName(String username){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where email = ?", new String[] {username});
        if(cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkUNameCode(String username, String code){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where email = ? and code = ?", new String[] {username,code});
        if(cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }
}
