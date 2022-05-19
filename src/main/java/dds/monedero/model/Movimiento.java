package dds.monedero.model;

import java.time.LocalDate;

public class Movimiento {
  private LocalDate fecha;
  // Nota: En ningún lenguaje de programación usen jamás doubles (es decir, números con punto flotante) para modelar dinero en el mundo real.
  // En su lugar siempre usen numeros de precision arbitraria o punto fijo, como BigDecimal en Java y similares
  // De todas formas, NO es necesario modificar ésto como parte de este ejercicio. 
  private double monto;
  private TipoMovimiento tipoMovimiento;

  public Movimiento(LocalDate fecha, double monto, TipoMovimiento tipoMovimiento) {
    this.fecha = fecha;
    this.monto = monto;
    this.tipoMovimiento = tipoMovimiento;
  }

  public double getMonto() {
    return monto;
  }

  public boolean esDeLaFecha(LocalDate fecha) {
    return this.fecha.equals(fecha);
  }

  public boolean iS(TipoMovimientoEnum tipo) {
    return tipoMovimiento.getTipoExplicito() == tipo;
  }

  public double calcularValor() {
    return tipoMovimiento.calcularValor(this);
  }
}
