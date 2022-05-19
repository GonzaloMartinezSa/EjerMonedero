package dds.monedero.model;

public class Deposito implements TipoMovimiento{
  private TipoMovimientoEnum tipoExplicito = TipoMovimientoEnum.DEPOSITO;

  public TipoMovimientoEnum getTipoExplicito(){
    return tipoExplicito;
  }

  public double calcularValor(Movimiento movimiento){
    return movimiento.getMonto();
  }
}
