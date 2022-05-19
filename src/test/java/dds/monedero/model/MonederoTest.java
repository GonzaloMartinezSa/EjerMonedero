package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MonederoTest {
  private Cuenta cuenta;

  @BeforeEach
  void init() {
    cuenta = new Cuenta();
  }

  @Test
  void Poner() {
    cuenta.poner(1500);
    assertEquals(1, cuenta.getMovimientos().stream().filter(movimiento -> movimiento.getMonto() == 1500).count());
  }

  @Test
  void PonerMontoNegativo() {
    assertThrows(MontoNegativoException.class, () -> cuenta.poner(-1500));
  }

  @Test
  void TresDepositos() {
    cuenta.poner(1500);
    cuenta.poner(456);
    cuenta.poner(1900);
    assertEquals(3, cuenta.getMovimientos().stream().filter(movimiento -> movimiento.isDeposito()).count());
  }

  @Test
  void MasDeTresDepositos() {
    assertThrows(MaximaCantidadDepositosException.class, () -> {
          cuenta.poner(1500);
          cuenta.poner(456);
          cuenta.poner(1900);
          cuenta.poner(245);
    });
  }

  @Test
  void ExtraerMasQueElSaldo() {
    assertThrows(SaldoMenorException.class, () -> {
          cuenta.setSaldo(90);
          cuenta.sacar(1001);
    });
  }

  @Test
  public void ExtraerMasDe1000() {
    assertThrows(MaximoExtraccionDiarioException.class, () -> {
      cuenta.setSaldo(5000);
      cuenta.sacar(1001);
    });
  }

  @Test
  public void ExtraerMontoNegativo() {
    assertThrows(MontoNegativoException.class, () -> cuenta.sacar(-500));
  }

  @Test
  public void SaldoSeActualizaAlHacerMovimento() {
    cuenta.setSaldo(5000);
    cuenta.poner(500);
    assertEquals(5500, cuenta.getSaldo());
  }

  @Test
  public void MontoExtraidoEnUnaFecha() {
    cuenta.setSaldo(5000);
    cuenta.sacar(150);
    cuenta.sacar(300);
    assertEquals(450, cuenta.getMontoExtraidoA(LocalDate.now()));
  }
  @Test
  public void AgregarMovACuenta() {
    Movimiento mov = new Movimiento(LocalDate.now(), 500, true);
    mov.agregateA(cuenta);
    assertEquals(1, cuenta.getMovimientos().stream().filter(movimiento -> movimiento.getFecha().equals(LocalDate.now()) &&
        movimiento.getMonto()==mov.getMonto() && movimiento.isDeposito()==mov.isDeposito()).count());
  }

}