package ar.edu.utn.frba.dds;

import java.time.LocalDate;

public class PersonaFisica extends Donante {
  public Mail mail;
  public String nombreCompleto;
  private int edad;
  private String genero;
  public String direccionActual;
  private String documentoIdentidad;  // algo mejor que esta forma

  public PersonaFisica(Mail email, String nombre, String apellido,
                       String documento) {
    mail = email;
    nombreCompleto = nombre + " " + apellido;
    documentoIdentidad = documento;
  }

  public void setEdad(LocalDate fechaNacimiento) {
    LocalDate fechaActual = LocalDate.now();
    edad = fechaActual.getYear() - fechaNacimiento.getYear();
  }

  public void setGenero(String gen) {
    gen.toUpperCase();
    if(gen.contains("HOMBRE") || gen.contains("MUJER") || gen.contains("OTRO")) {
      genero = gen;
      return;
    }
    genero = "NODEFINIDO";
  }

  public void setDireccion(String direccion) {
    direccion.toUpperCase();
    direccionActual = direccion;
  }

  public void donar() {}

}
