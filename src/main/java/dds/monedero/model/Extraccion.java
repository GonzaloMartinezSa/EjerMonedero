package dds.monedero.model;

public class Extraccion implements TipoMovimiento{
  private TipoMovimientoEnum tipoExplicito = TipoMovimientoEnum.EXTRACCION;

  public TipoMovimientoEnum getTipoExplicito(){
    return tipoExplicito;
  }

  public double calcularValor(Movimiento movimiento){
    return movimiento.getMonto();
  }
}
