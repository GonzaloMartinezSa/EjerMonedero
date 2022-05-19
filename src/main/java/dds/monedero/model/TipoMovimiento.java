package dds.monedero.model;

public interface TipoMovimiento {
  public double calcularValor(Cuenta cuenta, Movimiento movimiento);
  public TipoMovimientoEnum getTipoExplicito();
}
