package com.example.pruebapractica2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void irAComida(View view) {
        Intent intent = new Intent(this, comida.class);
        startActivity(intent);
    }
    public void irACarrito(View view) {
        Intent intent = new Intent(this, carrito.class);
        startActivity(intent);
    }
    public void irAHistorial(View view) {
        Intent intent = new Intent(this, historial.class);
        startActivity(intent);
    }
    public void irACerrar(View view) {
        finishAffinity();
    }



}