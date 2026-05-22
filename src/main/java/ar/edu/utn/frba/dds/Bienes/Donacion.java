package ar.edu.utn.frba.dds.Bienes;

import ar.edu.utn.frba.dds.Donante;

import java.util.ArrayList;
import java.util.List;


public class Donacion {
  private String descripcionGeneral;
  private List<Bien> bienes;
  private Donante donante;

  public Donacion(String descripcionGeneral, Donante donante, List<Bien> bienes) {
    this.descripcionGeneral = descripcionGeneral;
    this.donante = donante;
    this.bienes = new ArrayList<Bien>();
  }

  public void agregarBien(Bien bien) {
    this.bienes.add(bien);
  }

  /**
   * Devuele bienes.
   */

  public List<Bien> getContenido() {
    return bienes;
  }
}
