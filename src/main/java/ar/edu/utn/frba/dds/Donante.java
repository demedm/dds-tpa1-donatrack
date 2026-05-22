package ar.edu.utn.frba.dds;

public interface Donante {

  String getNombre();

  Mail getMailContacto();

  boolean actualizarInfo(String nombre, String documento, MedioContacto telefono);

  Identificacion getDocumento();

  Telefono getTelefonoContacto();
  
  Necesidad donar();

}
