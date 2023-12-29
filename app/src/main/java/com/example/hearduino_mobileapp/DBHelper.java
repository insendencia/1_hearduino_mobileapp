package com.example.hearduino_mobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DENAME = "Account.db"; //name of the database

    public DBHelper(Context context) {
        super(context, "Account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create Table users(username TEXT primary key, name TEXT, code TEXT, relation TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int i, int i1) {
        myDatabase.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String setName, String setUsername, String setCode, String setAnswer, String setAccount, String setRelation, byte[] setImage){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Full Name", setName);
        contentValues.put("Username", setUsername);
        contentValues.put("Passcode", setCode);
        contentValues.put("Answer", setAnswer);
        contentValues.put("Connected Account", setAccount);
        contentValues.put("Relation", setRelation);
        contentValues.put("Image", setImage);
        long result = myDatabase.insert("account", null, contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkUName(String username){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where Username = ?", new String[] {username});
        if(cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkUNameCode(String setUsername, String setCode){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where Username = ? and Passcode = ?", new String[] {setUsername, setCode});
        if(cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }

    public Bitmap getImage(String setUsername){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where Image = ?", new String[]{setUsername});
        cursor.moveToFirst();
        byte[] bitmap = cursor.getBlob(1);
        Bitmap image = BitmapFactory.decodeByteArray(bitmap, 0, bitmap.length);
        return image;
    }

}
