package ar.edu.utn.frba.dds.necesidad;

public class Peticion {
  private String subclase;
  private int cantidad;

  public Peticion(String subclase, int cantidad) {
    this.subclase = subclase;
    this.cantidad = cantidad;
  }

  public String getSubclase() {
    return subclase;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}
