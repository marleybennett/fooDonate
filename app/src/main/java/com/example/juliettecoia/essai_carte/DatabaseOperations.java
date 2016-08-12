package com.example.juliettecoia.essai_carte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.juliettecoia.essai_carte.TableData.TableInfo;

/**
 * Created by marleybennett on 8/3/16.
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + TableData.TableInfo.TABLE_NAME +
            "(" + TableInfo.USER_NAME + "," + TableInfo.USER_ORG + "," + TableInfo.USER_ADDRESS + ","
            + TableInfo.USER_PHONE + ","    +  TableInfo.USER_EMAIL + "," + TableInfo.USER_PASS +  ","  +  TableInfo.USER_ACCPTDON +" BOOLEAN);";

    public DatabaseOperations(Context context) {
        super(context, TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operations", "Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database Operations", "Database Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2)
    {}

    public void putInformation(DatabaseOperations dop, String name, String org, String address, String phone, String email, String password, boolean accptDon){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TableInfo.USER_NAME, name);
        cv.put(TableInfo.USER_ORG, org);
        cv.put(TableInfo.USER_ADDRESS, address);
        cv.put(TableInfo.USER_PHONE, phone);
        cv.put(TableInfo.USER_EMAIL, email);
        cv.put(TableInfo.USER_PASS, password);
        cv.put(TableInfo.USER_ACCPTDON, accptDon);

        long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);

        Log.d("Database Operations", "One raw inserted");
    }

    public Cursor getInformation(DatabaseOperations dop)
    {
        SQLiteDatabase SQ  = dop.getReadableDatabase();

        String[] columns = {TableInfo.USER_NAME, TableInfo.USER_ORG, TableInfo.USER_ADDRESS, TableInfo.USER_PHONE, TableInfo.USER_EMAIL, TableInfo.USER_PASS, TableInfo.USER_ACCPTDON};
        Cursor CR  = SQ.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return CR;
    }
}
