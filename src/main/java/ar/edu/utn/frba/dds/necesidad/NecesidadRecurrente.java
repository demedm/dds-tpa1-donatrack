package ar.edu.utn.frba.dds.necesidad;

public class NecesidadRecurrente extends Necesidad {
  public int diasAvencer;

  public NecesidadRecurrente(int diasAvencer) {
    super();
    this.diasAvencer = diasAvencer;
  }

  public int getDiasAvencer() {
    return diasAvencer;
  }
}
