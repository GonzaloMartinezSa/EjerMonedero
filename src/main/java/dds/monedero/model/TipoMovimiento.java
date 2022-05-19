package dds.monedero.model;

public interface TipoMovimiento {
  public double calcularValor(Movimiento movimiento);
  public TipoMovimientoEnum getTipoExplicito();
}
