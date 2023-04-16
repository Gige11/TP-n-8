package Ejercicio;

public class DescuentoFijo extends Descuento{

    @Override
    public double CalcularvalorFinal(double montoSinDes){

        if (montoSinDes == 0){
            throw new RuntimeException("El precio del carrito no puede ser 0");
        }
        else {
            double descuento = montoSinDes - this.getMontoDesc();
            if(descuento > 0){
                return  descuento;
            }else {
                throw  new RuntimeException("El resultado del descuento no puede ser un monto negativo");
            }

        }
    }
}