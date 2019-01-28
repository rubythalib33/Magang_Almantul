package com.biptek.posbiptek.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UserCRUD {
    private static final String LOGTAG = "POS_BIPTEK_SYS";
    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    private static final String[] allColumns = {
            "username",
            "password",
            "jabatan",
            "nama_lengkap",
            "no_telepon"
    };

    public UserCRUD(Context context){
        dbhandler = new DatabaseHelper(context);
    }

    public void open () {
        Log.i (LOGTAG, "Datanase Opened");
        database = dbhandler.getWritableDatabase();
    }

    public void close () {
        Log.i (LOGTAG, "Database Closed");
        dbhandler.close();
    }

    public void addUser(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user.getUsername());
        contentValues.put("password", user.getPassword());
        contentValues.put("jabatan", user.getJabatan());
        contentValues.put("nama_lengkap", user.getNama_lengkap());
        contentValues.put("no_telepon", user.getNo_telepon());
        database.insert("user", null, contentValues);
    }

    //mendapatkan 1 user
    public User getUser (String username){
        Cursor cursor = database.query("user",
                allColumns,
                "username=?",
                new String[]{username},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        User user = new User(cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));

        return user;
    }

    //mendapatkan semua user
    public List<User> getAllUser(){
        Cursor cursor = database.query("user",
                allColumns,
                null,
                null,
                null,
                null,
                null);

        List<User> users = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                User user = new User();
                user.setUsername(cursor.getString(cursor.getColumnIndex("username")));
                user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                user.setJabatan(cursor.getString(cursor.getColumnIndex("jabatan")));
                user.setNama_lengkap(cursor.getString(cursor.getColumnIndex("nama_lengkap")));
                user.setNo_telepon(cursor.getString(cursor.getColumnIndex("no_telepon")));
                users.add(user);
            }
        }

        return users;
    }

    public void updateUser(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user.getUsername());
        contentValues.put("password", user.getPassword());
        contentValues.put("jabatan", user.getJabatan());
        contentValues.put("nama_lengkap", user.getNama_lengkap());
        contentValues.put("no_telepon", user.getNo_telepon());
        database.update("user", contentValues, "username=?", new String[]{user.getUsername()});
    }

    public void deleteUser(User user){
        database.delete("user", "username=?", new String[]{user.getUsername()});
    }
}
