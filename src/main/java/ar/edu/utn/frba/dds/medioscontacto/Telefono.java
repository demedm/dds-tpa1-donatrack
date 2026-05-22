package ar.edu.utn.frba.dds.medioscontacto;

public class Telefono implements MedioContacto {
  public String nroTelefono;

  public Telefono(String telefono) {
    nroTelefono = telefono;
  }

  @Override
  public String getMedioContacto() {
    return nroTelefono;
  }

  @Override
  public void contactar() {

  }

}
