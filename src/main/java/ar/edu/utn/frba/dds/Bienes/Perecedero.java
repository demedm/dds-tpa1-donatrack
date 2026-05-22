package ar.edu.utn.frba.dds.Bienes;

import java.util.Date;
import java.util.stream.Stream;

public
class Perecedero implements Caracteristica {
  private Date fechaDeVencimiento;

  public Perecedero(Date fechaDeVencimiento) {
    this.fechaDeVencimiento = fechaDeVencimiento;
  }

  @Override
  public boolean coincideCon(Caracteristica caracteristica) {
    return Stream.of(caracteristica)
        .filter(c->c.getClass().equals(Perecedero.class))
        .map(c->(Perecedero) c)
        .anyMatch(p -> p.fechaDeVencimiento.equals(this.fechaDeVencimiento));
  }
}