package dds.monedero.model;

public class Extraccion {
  public double calcularValor(Cuenta cuenta, Movimiento movimiento){
    return cuenta.getSaldo() - movimiento.getMonto();
  }
}
