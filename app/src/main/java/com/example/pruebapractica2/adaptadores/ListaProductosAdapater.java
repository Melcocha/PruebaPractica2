package com.example.pruebapractica2.adaptadores;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebapractica2.R;
import com.example.pruebapractica2.entidades.Productos;

import java.util.ArrayList;

public class ListaProductosAdapater extends RecyclerView.Adapter<ListaProductosAdapater.ProductoViewHolder>
{

    ArrayList<Productos> listaProductos;

    public ListaProductosAdapater(ArrayList<Productos> listaProductos){
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_producto,null,false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.viewComprador.setText(listaProductos.get(position).getComprador());
        holder.viewProducto_name.setText(listaProductos.get(position).getProducto_name());
        holder.viewBebida_name.setText(listaProductos.get(position).getBebida_name());
        holder.viwProducto_cantidad.setText(listaProductos.get(position).getProducto_cantidad());
        holder.viewBebida_cantidad.setText(listaProductos.get(position).getBebida_cantidad());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {

        TextView viewComprador,viewProducto_name,viewBebida_name,viwProducto_cantidad,viewBebida_cantidad,textView2;
        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewComprador = itemView.findViewById(R.id.viewcomprador);
            viewProducto_name = itemView.findViewById(R.id.viewProducto_name);
            viewBebida_name = itemView.findViewById(R.id.viewBebida_name);
            viwProducto_cantidad = itemView.findViewById(R.id.viewProducto_cantidad);
            viewBebida_cantidad = itemView.findViewById(R.id.viewBebida_cantidad);



        }

        public void bind(Productos producto) {
            // Asignar los valores a los TextViews
            viewComprador.setText(producto.getComprador());
            viewProducto_name.setText(producto.getProducto_name());
            viewBebida_name.setText(producto.getBebida_name());
            viwProducto_cantidad.setText(producto.getProducto_cantidad());
            viewBebida_cantidad.setText(producto.getBebida_cantidad());

            // Verificar si el comprador es "Tacos al pastor"
            if (producto.getComprador().equals("Tacos al pastor")) {
                try {
                    // Convertir la cantidad de productos a un valor numérico
                    double cantidadProductos = Double.parseDouble(producto.getProducto_cantidad());

                    // Multiplicar la cantidad de productos por 5.99
                    double total = cantidadProductos * 5.99;

                    // Mostrar el total en el TextView correspondiente
                    textView2.setText(String.format("%.2f", total));
                } catch (NumberFormatException e) {
                    // Manejar la excepción si la cantidad de productos no es un número válido
                    textView2.setText("Error");
                }
            } else {
                // Si el comprador no es "Tacos al pastor", mostrar el TextView2 vacío
                textView2.setText("");
            }
        }

    }
}
