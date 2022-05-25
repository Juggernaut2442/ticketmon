package com.example.ticketapp.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String dbName = "ticketmon";
    private static final int dbVersion = 1;
    public Database(@Nullable Context context) {
        super(context, dbName,null,dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    // creating table
        String createUsers = "CREATE TABLE \"user\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"surname\"\tTEXT,\n" +
                "\t\"mail\"\tTEXT,\n" +
                "\t\"password\"\tTEXT,\n" +
                "\t\"authority\"\tINTEGER DEFAULT 1,\n" +
                "\t\"status\"\tINTEGER DEFAULT 1,\n" +
                "\t\"date\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";
        String createTickets = "CREATE TABLE \"tickets\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"ticketID\"\tINTEGER,\n" +
                "\t\"userID\"\tINTEGER,\n" +
                "\t\"subject\"\tTEXT,\n" +
                "\t\"message\"\tTEXT,\n" +
                "\t\"status\"\tINTEGER DEFAULT 0,\n" +
                "\t\"date\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";
        String createReplys = "CREATE TABLE \"replys\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"ticketID\"\tINTEGER,\n" +
                "\t\"userID\"\tINTEGER,\n" +
                "\t\"message\"\tTEXT,\n" +
                "\t\"date\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";
        db.execSQL(createUsers);
        db.execSQL(createTickets);
        db.execSQL(createReplys);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long registerUser(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name",users.getName());
        cv.put("surname",users.getSurname());
        cv.put("mail",users.getMail());
        cv.put("password",users.getPassword());
        cv.put("authority",users.getAuthority());
        cv.put("status",users.getStatus());
        cv.put("date",users.getDate());

      long id =  db.insert("user",null,cv);
      return id;
    }
    public  long openTicket(Tickets tickets){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("ticketID",tickets.getTicketID());
        cv.put("userID",tickets.getUserID());
        cv.put("subject",tickets.getSubject());
        cv.put("message",tickets.getMessage());
        cv.put("status",tickets.getStatus());
        cv.put("date",tickets.getDate());

        long id = db.insert("tickets",null,cv);
        return id;
    }
    public Boolean checkUserID(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from user where mail =?",new String[]{email});
        if(cursor.getCount() > 0){
            return  true;
        }else{
            return  false;
        }

    }

    public Boolean checkUserMailPass(String email,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from user where mail =? and password =?",new String[]{email,pass});
        if(cursor.getCount() > 0){
            return  true;
        }else{
            return  false;
        }
    }

}
