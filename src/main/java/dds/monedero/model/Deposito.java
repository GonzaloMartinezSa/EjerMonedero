package dds.monedero.model;

public class Deposito {
  public double calcularValor(Cuenta cuenta, Movimiento movimiento){
    return cuenta.getSaldo() + movimiento.getMonto();
  }
}
