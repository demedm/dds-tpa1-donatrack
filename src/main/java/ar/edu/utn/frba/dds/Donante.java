package ar.edu.utn.frba.dds;

public interface Donante {

  public void donar();

  public boolean tieneEmail(String email) {
    return this.email.equalsIgnoreCase(email);

  }
}
