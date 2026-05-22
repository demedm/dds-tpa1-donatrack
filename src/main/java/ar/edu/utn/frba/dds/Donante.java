package ar.edu.utn.frba.dds;

public interface Donante {
  void donar();

  String getNombre();

  Mail getMailContacto();

  boolean actualizarInfo(String nombre, String documento, MedioContacto telefono);

  Identificacion getDocumento();

  Telefono getTelefonoContacto();
  
  public Necesidad donar();

  public boolean tieneEmail(String email) {
    return this.email.equalsIgnoreCase(email);

  }
}
