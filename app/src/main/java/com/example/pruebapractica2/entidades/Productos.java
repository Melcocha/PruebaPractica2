package com.example.pruebapractica2.entidades;

public class Productos {

    private int id ;
    private String comprador;
    private String producto_name;
    private String bebida_name;
    private String producto_cantidad;
    private String bebida_cantidad;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getComprador() {
        return comprador;
    }
    public void setComprador(String comprador) {
        this.comprador = comprador;
    }
    public String getProducto_name() {
        return producto_name;
    }
    public void setProducto_name(String producto_name) {
        this.producto_name = producto_name;
    }
    public String getBebida_name() {
        return bebida_name;
    }
    public void setBebida_name(String bebida_name) {
        this.bebida_name = bebida_name;
    }
    public String getProducto_cantidad() {
        return producto_cantidad;
    }
    public void setProducto_cantidad(String producto_cantidad) {
        this.producto_cantidad = producto_cantidad;
    }
    public String getBebida_cantidad() {
        return bebida_cantidad;
    }
    public void setBebida_cantidad(String bebida_cantidad) {
        this.bebida_cantidad = bebida_cantidad;
    }

}
