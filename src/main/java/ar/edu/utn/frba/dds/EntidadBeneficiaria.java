package ar.edu.utn.frba.dds;

import java.util.List;

public class EntidadBeneficiaria extends Entidad {
  List<MedioContacto> contactosRepresentantes;

  public EntidadBeneficiaria(String razon, String tipoEntidad, List<MedioContacto> contactos) {
    super(razon, tipoEntidad);
    contactosRepresentantes = contactos;
  }

}
