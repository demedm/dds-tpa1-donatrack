package ar.edu.utn.frba.dds;

import java.util.List;

public class EntidadBeneficiaria extends Entidad{
  String direccion;

  public EntidadBeneficiaria(String razon, List<MedioContacto> telefonoOrganizacion, List<Mail> mailRepresentantes, String direccionEntidad){
    super(razon, mailRepresentantes);
    SetMedioContacto(telefonoOrganizacion);
    direccion = direccionEntidad;
  }

}
