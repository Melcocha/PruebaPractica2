package com.example.pruebapractica2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pruebapractica2.db.DbCarrito;
import com.example.pruebapractica2.db.DbHelper;


public class comida extends AppCompatActivity {
    Button btnCrear;
    Spinner spinnerComida;
    Spinner spinnerBebidas;
    TextView textViewPrecioComida;
    TextView textViewPrecioBebida;
    TextView cantidadComida;
    TextView cantidadBebida;
    TextView comprador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_comida);


        Spinner spinnerComida = findViewById(R.id.spinnerComida);
        Spinner spinnerBebidas = findViewById(R.id.spinnerBebidas);
        textViewPrecioComida = findViewById(R.id.textViewPrecioComida);
        textViewPrecioBebida = findViewById(R.id.textViewPrecioBebida);
        cantidadComida = findViewById(R.id.editTextCantidadComida);
        cantidadBebida = findViewById(R.id.editTextCantidadBebida);
        comprador = findViewById(R.id.editTextComprador);
        btnCrear = findViewById(R.id.buttonIrACobrar);

        spinnerComida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el precio seleccionado del array de recursos
                String[] preciosComida = getResources().getStringArray(R.array.precios_comidas_mexicanas);
                String precioSeleccionado = preciosComida[position];

                // Actualizar el TextView con el precio seleccionado
                textViewPrecioComida.setText(precioSeleccionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada si no se selecciona nada
            }
        });
        spinnerBebidas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el precio seleccionado del array de recursos
                String[] preciosBebidas = getResources().getStringArray(R.array.precios_bebidas);
                String precioSeleccionado = preciosBebidas[position];

                // Actualizar el TextView con el precio seleccionado
                textViewPrecioBebida.setText(precioSeleccionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada si no se selecciona nada
            }
        });
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //DbHelper dbHelper = new DbHelper(comida.this);
                //SQLiteDatabase db = dbHelper.getWritableDatabase();
                // if(db != null){
            //Toast.makeText(comida.this,"BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();
                    //}else {
            //Toast.makeText(comida.this,"BASE DE DATOS NO CREADA",Toast.LENGTH_LONG).show();
            //}

                DbCarrito dbCarrito = new DbCarrito(comida.this);
                //dbCarrito.insertarProducto(comprador.getText().toString(),cantidadComida.getText().toString(),cantidadBebida.getText().toString());
                long id = dbCarrito.insertarProducto(comprador.getText().toString(),"Carne","Horchata",2,3,4.5);

                if(id>0){
                    Toast.makeText(comida.this,"REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                    limpiar();
                }else {
                    Toast.makeText(comida.this,"ERROR AL GUARDAR",Toast.LENGTH_LONG).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void limpiar(){
        comprador.setText("");
    }


    public void irAInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void irACarrito(View view) {
        Intent intent = new Intent(this, carrito.class);
        startActivity(intent);
    }







}
