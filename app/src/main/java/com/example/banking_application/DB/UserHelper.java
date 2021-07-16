package com.example.banking_application.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.banking_application.DB.UserContract.UserEntry;
import com.example.banking_application.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(1234,'Darshan N Divakar', 'darshan@gmail.com','1001','8472569083', 100000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1314,'Virat S', 'virat@gmail.com','1010','9035671289', 30000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9112,'Chandan A S', 'chandan@gmail.com','1011','8024567190', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1516,'Giridhar S Benkipur', 'giri@gmail.com','1100','7290748901', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1718,'Abhishek P Jain', 'abhi@gmail.com','1101','9033478910', 7000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1920,'Akul Bharadwaj', 'akul@gmail.com','1111','9923678014', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2122,'Aloka K', 'alok@gmail.com','1000','8080290784', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2324,'Rithik K', 'rithik@gmail.com','0001','9998802478', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2526,'Priyanka D', 'priyanka@gmail.com','0010','9083090908', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2728,'Soniya P', 'soniya@gmail.com','0011','9647890278', 38000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2930,'Anushka V', 'anushka@gmail.com','0100','8210789345', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3132,'Ganesh S', 'ganesh@gmail.com','0101','9840863789', 17000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3334,'Praveen Shet', 'praveen@gmail.com','0110','9287790649', 18000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3536,'Pramodh Khanna', 'pramodh@gmail.com','0111','8282901678', 7900)");
        db.execSQL("insert into " + TABLE_NAME + " values(3738,'Vishwas T', 'vishwas@gmail.com','0000','8210783469', 2000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
