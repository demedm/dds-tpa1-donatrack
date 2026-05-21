package ar.edu.utn.frba.dds;

import java.util.List;

public class EntidadBeneficiaria implements Entidad {
  public String direccion;
  private String tipo;

  public void setMedioContacto(MedioContacto medioContactoElement) {
    mediosContacto.add(medioContactoElement);
  }

  public EntidadBeneficiaria(String razon, String tipoEntidad,
                             MedioContacto telefonoOrganizacion,
                             List<Mail> contactoRepresentantes, String direccionEntidad) {
    razonSocial.copyValueOf(razon.toCharArray());
    for(Mail mail : contactoRepresentantes) {
      mailRepresentantes.add(mail);
    }
    setMedioContacto(telefonoOrganizacion);
    direccion = direccionEntidad;
    tipo = tipoEntidad; //escuelas rurales, comedores, espacios de tutoría de niños, entre otros
  }

}
