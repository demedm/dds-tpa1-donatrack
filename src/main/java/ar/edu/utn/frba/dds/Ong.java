package ar.edu.utn.frba.dds;

import java.util.List;

public class Ong extends Entidad {
  private List<Donante> historialDonantes;

  public Ong(String razon, List<Mail> representantesMailList) {
    razonSocial = razon;
    mailRepresentantes = representantesMailList;
  }

}
