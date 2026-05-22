package ar.edu.utn.frba.dds.Bienes;

import java.util.stream.Stream;

public class Estado implements Caracteristica {
  private EstadoUso estado;

  public Estado(EstadoUso estado) {
    this.estado = estado;
  }
  @Override
  public boolean coincideCon(Caracteristica caracteristica) {
    return Stream.of(caracteristica)
        .filter(c->c.getClass().equals(Estado.class))
        .map(c->(Estado) c)
        .anyMatch(e -> e.estado.equals(this.estado));
  }

}
