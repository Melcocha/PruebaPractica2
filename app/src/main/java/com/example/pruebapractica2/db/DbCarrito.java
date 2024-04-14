package com.example.pruebapractica2.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;


import androidx.annotation.Nullable;

import com.example.pruebapractica2.entidades.Productos;

import java.util.ArrayList;

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

    public ArrayList<Productos> mostrarProductos() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Productos> listaProductos = new ArrayList<>();
        Productos producto = null;
        Cursor cursorProductos = null;

        cursorProductos = db.rawQuery("SELECT * FROM " + TABLE_CARRITO, null);

        if (cursorProductos.moveToFirst()) {
            do {
                producto = new Productos();
                producto.setId(cursorProductos.getInt(0));
                producto.setComprador(cursorProductos.getString(1));
                producto.setProducto_name(cursorProductos.getString(2));
                producto.setProducto_cantidad(cursorProductos.getString(3));
                producto.setBebida_name(cursorProductos.getString(4));
                producto.setBebida_cantidad(cursorProductos.getString(5));
                listaProductos.add(producto);
            }while (cursorProductos.moveToNext());

        }

        cursorProductos.close();

        return listaProductos;
    }

    public ArrayList<Productos> mostrarUltimoProducto() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Productos> listaProductos = new ArrayList<>();
        Productos producto = null;
        Cursor cursorProductos = null;

        cursorProductos = db.rawQuery("SELECT * FROM " + TABLE_CARRITO + " ORDER BY id DESC LIMIT 1", null);

        if (cursorProductos.moveToFirst()) {
            do {
                producto = new Productos();
                producto.setId(cursorProductos.getInt(0));

                producto.setComprador(cursorProductos.getString(1));

                producto.setProducto_name(cursorProductos.getString(2));
                producto.setProducto_cantidad(cursorProductos.getString(3));
                producto.setBebida_name(cursorProductos.getString(4));
                producto.setBebida_cantidad(cursorProductos.getString(5));
                listaProductos.add(producto);
            }while (cursorProductos.moveToNext());

        }

        cursorProductos.close();

        return listaProductos;
    }
}
