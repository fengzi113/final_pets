package com.example.android.pets.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import  com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by fengzi113 on 2018/2/26.
 */

public  class PetDbHelper extends SQLiteOpenHelper {

    private static final String DATEBASE_NAME = "shelter.db";
    private static final int DATEBASE_VERSION = 1;

    public PetDbHelper(Context context) {
        super(context, DATEBASE_NAME, null, DATEBASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

     String SQL_CREATE_ENTRIES =   "CREATE TABLE " + PetEntry.TABLE_NAME + "("+
                PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL,"+
                PetEntry.COLUMN_PET_BREED + " TEXT NOT NULL,"+
                PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL DEFAULT 0,"+
                PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0"+
                ");";
        db.execSQL(SQL_CREATE_ENTRIES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
