package ar.edu.utn.frba.dds;

import java.util.List;

public class ONG extends Entidad {
  List<Persona> historialDonantes;

  public ONG(String razon, List<Mail> representantesMailList) {
    super(razon, representantesMailList);
  }

}
