package com.example.karthik.remainder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by karthik on 13-07-2018.
 */

public class DeleteTodo extends SQLiteOpenHelper{
    private static final String database_name = "delteTodo";
    private static final String table_name  = "delteTodoTableName";
    private static final String Col1 = "_id";
    private static final String Col2 = "task";
    private static final String Col3 = "date";
    private static final String Col4 = "time";
private static final String Col5 = "colour";

    public DeleteTodo(Context context) {
        super(context,database_name,null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + table_name + "(" + Col1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + Col2 + " VARCHAR(255)," + Col3 + " VARCHAR(255)," + Col4 + " VARCHAR(255)," + Col5 + " VARCHAR(255)) ;");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addData(String task, String date, String time,String colour) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col2, task);
        contentValues.put(Col3, date);
        contentValues.put(Col4, time);
        contentValues.put(Col5,colour);
        database.insert(table_name, null, contentValues);
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + table_name + "", null);
        return cursor;
    }

    public void deleteData(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_name, Col1 + "=" + id, null);
    }

}
