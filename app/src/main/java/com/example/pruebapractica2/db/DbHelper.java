package com.example.pruebapractica2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "dato.db";
    public static final String TABLE_CARRITO = "t_carrito";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_CARRITO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "comprador TEXT NOT NULL," +
                "producto_comida TEXT NOT NULL," +
                "cantidad_comida INT NOT NULL," +
                "producto_bebida TEXT NOT NULL," +
                "cantidad_bebida INT NOT NULL," +
                "precio REAL NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_CARRITO);
        onCreate(db);
    }
}
