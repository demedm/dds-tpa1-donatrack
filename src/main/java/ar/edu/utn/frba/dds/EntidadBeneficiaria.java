package ar.edu.utn.frba.dds;

import java.util.List;

public class EntidadBeneficiaria extends Entidad {
  public String direccion;
  private String tipo;

  public EntidadBeneficiaria(String razon, String tipoEntidad,
                             MedioContacto telefonoOrganizacion,
                             List<Mail> contactoRepresentantes, String direccionEntidad) {
    for (Mail mail : contactoRepresentantes) {
      mailRepresentantes.add(mail);
    }
    setMedioContacto(telefonoOrganizacion);
    direccion = direccionEntidad;
    tipo = tipoEntidad; //escuelas rurales, comedores, espacios de tutoría de niños, entre otros
  }

  public String getTipoEntidad() {
    return tipo;
  }

  public String getDireccion() {
    return direccion;
  }

}
