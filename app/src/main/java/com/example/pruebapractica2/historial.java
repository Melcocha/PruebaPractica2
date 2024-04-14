package com.example.pruebapractica2;

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

public class historial extends AppCompatActivity {
    RecyclerView listaProductos;
    ArrayList<Productos> listaArrayProductos;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historial);

        listaProductos = findViewById(R.id.listaVentas);

        listaProductos.setLayoutManager(new LinearLayoutManager(this));

        DbCarrito dbCarrito = new DbCarrito(historial.this);
        listaArrayProductos = new ArrayList<>();

        ListaProductosAdapater adapter = new ListaProductosAdapater(dbCarrito.mostrarProductos());
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


}