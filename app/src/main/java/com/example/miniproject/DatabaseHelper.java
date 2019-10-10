package com.example.miniproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
public static final String DATABASE_NAME="register.db";
public static final String TABLE_NAME="register";
public static final String COL_1="Uname";
public static final String COL_2="Contact_No";
public static final String COL_3="Password";
public static final String COL_4="Address";
    public static final String COL_5="Messname";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE" +TABLE_NAME+ "(Uname TEXT,Contact_No TEXT,Password TEXT,Adress TEXT,Messname TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        OnCreate(db);

    }

    private void OnCreate(SQLiteDatabase db) {
    }
}
