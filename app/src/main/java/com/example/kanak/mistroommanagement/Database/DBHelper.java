package com.example.kanak.mistroommanagement.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.kanak.mistroommanagement.model.Routine;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static  final  int DB_VERSION=1;
    private static final String DB_NAME="routine_db";
    private static final String ROUTINE_TABLE="routine_tbl";
    private static final String ID ="id";
    private static final String PERIOD ="peroid";
    private static final String SUBJECT ="subject";
    private static final String CODE ="code";
    private static final String DAY ="day";
    private static final String ROOM_NO ="room_no";



    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
/*        String CREATE_ROUTINE_TABLE = "CREATE TABLE "
                +DBHelper.ROUTINE_TABLE
                +"("
                + DBHelper.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +DBHelper.ROOM_NO +" TEXT PRIMARY KEY,"
                +DBHelper.PERIOD +" TEXT,"
                +DBHelper.SUBJECT+" TEXT,"
                +DBHelper.CODE+" TEXT,"
                +DBHelper.DAY+" TEXT "+
                ")";*/

        String CREATE_ROUTINE_TABLE= "CREATE TABLE "
                + DBHelper.ROUTINE_TABLE
                + "("
                + DBHelper.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DBHelper.ROOM_NO + " TEXT,"
                + DBHelper.PERIOD + " TEXT,"
                + DBHelper.SUBJECT + " TEXT,"
                + DBHelper.CODE + " TEXT,"
                + DBHelper.DAY + " TEXT " + ")";


        db.execSQL(CREATE_ROUTINE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+DBHelper.ROUTINE_TABLE);
        //Create Table again
        onCreate(db);
    }

    public boolean insertIntoRoutine(Routine routine)
    {
        boolean flag=false;
        final  SQLiteDatabase db=getWritableDatabase();

        final  String queryString = "Select "+"*FROM "
                + DBHelper.ROUTINE_TABLE + " where "
                +DBHelper.ROOM_NO+"='"+routine.getRoomNo()+"'";

        final Cursor cursor = db.rawQuery(queryString,null);

        if (cursor.getCount()>0){
            final  String update="Update "
                    +DBHelper.ROUTINE_TABLE+" set "
                    +DBHelper.ROOM_NO+ "='" +routine.getRoomNo() +"',"
                    +DBHelper.PERIOD+ "='" + routine.getPeriod() +"',"
                    +DBHelper.SUBJECT+ "='" + routine.getSubject() +"',"
                    +DBHelper.CODE+ "='" + routine.getCode() +"',"
                    +DBHelper.DAY+ "='" + routine.getDay() +"'"
                    +" where " +DBHelper.ROOM_NO +"='" +routine.getRoomNo()+"'";
            Log.e("update ", ">>" + update);
            db.execSQL(update);

            final ContentValues values = new ContentValues();
            values.put(DBHelper.ROOM_NO, routine.getRoomNo());
            values.put(DBHelper.PERIOD, routine.getPeriod());
            values.put(DBHelper.SUBJECT, routine.getSubject());
            values.put(DBHelper.CODE, routine.getCode());
            values.put(DBHelper.DAY, routine.getDay());

        }else {
            final ContentValues values = new ContentValues();
            values.put(DBHelper.ROOM_NO, routine.getRoomNo());
            values.put(DBHelper.PERIOD, routine.getPeriod());
            values.put(DBHelper.SUBJECT, routine.getSubject());
            values.put(DBHelper.CODE, routine.getCode());
            values.put(DBHelper.DAY, routine.getDay());

            db.insert(DBHelper.ROUTINE_TABLE, null, values);
            flag = true;
        }

        db.close();
        return flag;
    }
}
