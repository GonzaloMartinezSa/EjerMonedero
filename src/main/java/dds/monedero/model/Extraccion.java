package dds.monedero.model;

public class Extraccion implements TipoMovimiento{
  private TipoMovimientoEnum tipoExplicito = TipoMovimientoEnum.EXTRACCION;

  public TipoMovimientoEnum getTipoExplicito(){
    return tipoExplicito;
  }

  public double calcularValor(Cuenta cuenta, Movimiento movimiento){
    return cuenta.getSaldo() - movimiento.getMonto();
  }
}
