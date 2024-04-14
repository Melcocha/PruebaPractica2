package com.example.pruebapractica2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebapractica2.adaptadores.ListaProductosAdapater;
import com.example.pruebapractica2.db.DbCarrito;
import com.example.pruebapractica2.entidades.Productos;

import java.util.ArrayList;

public class carrito extends AppCompatActivity {
    RecyclerView listaProductos;
    ArrayList<Productos> listaArrayProductos;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_carrito);

        listaProductos = findViewById(R.id.listaCarrito);

        listaProductos.setLayoutManager(new LinearLayoutManager(this));

        DbCarrito dbCarrito = new DbCarrito(carrito.this);
        listaArrayProductos = new ArrayList<>();

        ListaProductosAdapater adapter = new ListaProductosAdapater(dbCarrito.mostrarUltimoProducto());
        listaProductos.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void irAInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void irAHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}