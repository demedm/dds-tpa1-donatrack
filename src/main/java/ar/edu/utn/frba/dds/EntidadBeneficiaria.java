package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.medioscontacto.Mail;
import ar.edu.utn.frba.dds.medioscontacto.MedioContacto;
import java.util.List;

public class EntidadBeneficiaria extends Entidad {
  String direccion;
  String tipo;

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
  
  public void crearNecesidad(GestorNecesidades gestor, Integer diasAvencer){
    Necesidad necesidad = new NecesidadRecurrente(this, diasAvencer);
    gestor.agregarNecesidad(necesidad);
  }

  public void crearNecesidad(GestorNecesidades gestor){
    Necesidad necesidad = new Necesidad(this);
    gestor.agregarNecesidad(necesidad);
  }

}
