package ar.edu.utn.frba.dds;

import java.util.List;

public class EntidadBeneficiaria extends Entidad{
  String direccion;
  String tipo;

  public EntidadBeneficiaria(String razon, String tipoEntidad, List<MedioContacto> telefonoOrganizacion, List<Mail> mailRepresentantes, String direccionEntidad){
    super(razon, mailRepresentantes);
    SetMedioContacto(telefonoOrganizacion);
    direccion = direccionEntidad;
    tipo = tipoEntidad; //escuelas rurales, comedores, espacios de tutoría de niños, entre otros
  }

}
