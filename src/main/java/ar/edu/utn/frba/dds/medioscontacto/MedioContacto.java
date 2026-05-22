package ar.edu.utn.frba.dds.medioscontacto;

import ar.edu.utn.frba.dds.Notificacion;

public interface MedioContacto {

  public String getMedioContacto();

  boolean contactar(Notificacion notificacion);

}
