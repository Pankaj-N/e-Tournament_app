package com.example.e_tournament;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "Contacts.db";
    private static final String TABLE_NAME = "Contacts";
    private static final String COLUMN_USERNAME = "Username";
    private static final String COLUMN_FIRSTNAME = "FirstName";
    private static final String COLUMN_Surname = "Surname";
    private static final String COLUMN_DOB = "DOB";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_ID = "ID";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
            "Username text not null, FirstName text not null, Email text not null, Password text not null, surname text not null, DOB text not null);";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null,  DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from Contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_USERNAME, c.getuname());
        values.put(COLUMN_FIRSTNAME, c.getfname());
        values.put(COLUMN_Surname, c.getSname());
        values.put(COLUMN_DOB, c.getDOB());
        values.put(COLUMN_EMAIL, c.getemail());
        values.put(COLUMN_PASSWORD, c.getpass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String Username)
    {
        db = this.getReadableDatabase();
        String query = "Select  Username, Password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if (a.equals(Username))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
