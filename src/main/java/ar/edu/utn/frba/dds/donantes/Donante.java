package ar.edu.utn.frba.dds.donantes;

import ar.edu.utn.frba.dds.medioscontacto.Mail;
import ar.edu.utn.frba.dds.medioscontacto.MedioContacto;
import ar.edu.utn.frba.dds.medioscontacto.Telefono;
import ar.edu.utn.frba.dds.necesidad.Necesidad;

public interface Donante {

  String getNombre();

  Mail getMailContacto();

  boolean actualizarInfo(String nombre, String documento, MedioContacto telefono);

  Identificacion getDocumento();

  Telefono getTelefonoContacto();
  
  Necesidad donar();

}
