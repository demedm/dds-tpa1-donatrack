package ar.edu.utn.frba.dds.bienes;

import java.util.Objects;

public class Subcategoria {
  private String nombre;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subcategoria that = (Subcategoria) o;
    return Objects.equals(nombre, that.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(nombre);
  }

}
