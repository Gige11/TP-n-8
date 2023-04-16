package Ejercicio;

public abstract class Descuento {
    private double montoSinDes;
    private double cantDesc;

    public double getMontoDesc() {
        return montoSinDes;
    }

    public void setMontoDesc(double montoSinDes) {
        this.montoSinDes = montoSinDes;
    }

    public double getcantDesc() {
        return cantDesc;
    }

    public void setcantDesc(double cantDesc) {
        this.cantDesc = cantDesc;
    }

    public abstract double CalcularvalorFinal(double montoSinDes) throws Exception;
}
