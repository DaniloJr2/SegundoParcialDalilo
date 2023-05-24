package com.emergentes.modelo;

public class Productos {
    private int id;
    private String descripcion;
    private int cantidad;    
    private float precio;
    private String categorias;

    public Productos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    
    
    @Override
    public String toString() {
        return "Participante{" + "id=" + id + ", descripcion=" + descripcion + ", "
                + "cantida=" + cantidad + ", precio=" + precio + ", categoria=" + categorias + '}';
    }
}
