package Ejercicio2;

import Ejercicio.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class ProbarCarritoConArchivo {
    public static void main(String[] args) throws IOException {

        ArrayList<Producto> productos = new ArrayList<>();

        File Archivo = new File("C:\\Users\\User\\Desktop\\ArgentinaPrograma\\Clase8\\src\\Ejercicio2\\ListaProductos.txt");
        String cadena;
        Scanner entrada = null;

        Persona cliente1 = new Persona("Matias","Gigena", LocalDate.of(1998,8,3));
        Carrito carrito1 = new Carrito(cliente1);

        try {
            entrada = new Scanner(Archivo);
            while (entrada.hasNext()){
                cadena = entrada.nextLine();
                ItemCarrito item =  cargarProductos(cadena,productos);
                carrito1.agregarItem(item);
            }

            carrito1.mostrarTitulo(); //Se muestra el titulo que contiene, el nombre del cliente, la fecha y los titulos de las columnas.

            ArrayList<ItemCarrito> itemsCarrito = carrito1.getItems(); //Se imprimen todos los items que forman parte del carrito.
            for(ItemCarrito item :itemsCarrito){
                System.out.println("  "+item.getCantidad()+"\t"+"\t"+item.getProducto().getPrecio()+"\t  "+item.getMontoItem()+"\t  "+item.getProducto().getNombre());
            }
            carrito1.mostrarTotal(); //Se calcula y muestra el total

            Descuento descuentoFijo= new DescuentoFijo();
            descuentoFijo.setMontoDesc(400);

            Descuento descPorcentual = new DescuentoPorcentaje();
            descPorcentual.setMontoDesc(15);

            System.out.println("Total c/descuento fijo = "+ descuentoFijo.CalcularvalorFinal(carrito1.getCalcularTotal()));
            System.out.println("Total c/descuento porcentual = "+ descPorcentual.CalcularvalorFinal(carrito1.getCalcularTotal()));

        } catch (FileNotFoundException e){
            System.out.println("Error con el archivo, no existe o no esta habilitado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (entrada !=null)
                entrada.close();
        }

    }
    public static ItemCarrito cargarProductos(String cadena,  ArrayList<Producto> productos){

        String[] items = cadena.split(",");
        String codigo = items[0];
        String nombre = items[1];
        float precio = Float.parseFloat(items[2]);
        int cantidad = Integer.parseInt(items[3]);

        Producto producto = new Producto(codigo,nombre,precio);
        productos.add(producto);
        ItemCarrito item = new ItemCarrito(producto,cantidad);
        return item;
    }
}

