package com.example.pruebapractica2.db;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;


import androidx.annotation.Nullable;

public class DbCarrito extends DbHelper{

    Context context;
    public DbCarrito(@Nullable Context context) {
        super(context);

        this.context = context;
    }

    public long insertarProducto(String comprador, String producto_comida,String producto_bebida,int cantidad_comida, int cantidad_bebida, Double precio){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("comprador", comprador);
            values.put("producto_comida", producto_comida);
            values.put("producto_bebida", producto_bebida);
            values.put("cantidad_comida", cantidad_comida);
            values.put("cantidad_bebida", cantidad_bebida);
            values.put("precio", precio);

            id = db.insert(TABLE_CARRITO,null,values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;

    }
}
