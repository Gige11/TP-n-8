package Ejercicio;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Carrito {
    private static int codigoCarrito =0;
    private Persona persona;
    private LocalDateTime fecha;
    private ArrayList<ItemCarrito> items;

    public Carrito(Persona persona) {
        this.persona = persona;
        this.codigoCarrito++;
        this.items = new ArrayList<>();
    }

    public int getCodigoCarrito() {
        return codigoCarrito;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ArrayList<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemCarrito> items) {
        this.items = items;
    }

    public LocalDateTime getFecha() {
        fecha = LocalDateTime.now();
        return fecha;
    }

    public void agregarItem(ItemCarrito item){
        items.add(item);
    }

    public void eliminarItem(ItemCarrito item){
        items.remove(item);
    }

    public double getCalcularTotal(){
        double precioFinal = 0;
        for (ItemCarrito item : items) {
            precioFinal += item.getProducto().getPrecio()*item.getCantidad();
        }
        return  precioFinal;
    }

    public void mostrarTitulo() {
        System.out.println("\nCliente= "+getPersona().getNombre()+" "+ getPersona().getApellido()+ "\t\t Fecha: "+ getFecha() +"\n");
        System.out.println("Cant | \tPrecio |  Importe  |  Producto \n----------------------------------------------");
    }


    public void mostrarTotal() {
        System.out.println("\nPrecio total: "+ getCalcularTotal());
    }
}
