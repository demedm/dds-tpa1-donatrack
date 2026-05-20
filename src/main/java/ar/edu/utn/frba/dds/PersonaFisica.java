package ar.edu.utn.frba.dds;

import java.time.LocalDate;

public class PersonaFisica {
  public Mail mail;
  public String nombreCompleto;
  private int edad;
  private String genero;
  public String direccionActual;
  private char documentoIdentidad[];  // algo mejor que esta forma

  public PersonaFisica(Mail email, String nombre, String apellido, LocalDate fechaNacimiento, char documento[], String gen, String direccion)
  {
    mail = email;
    nombreCompleto = nombre + " " + apellido;
    genero = gen; // buscar forma de definir solo: hombre, mujer, otro
    direccionActual = direccion;
    LocalDate fechaActual = LocalDate.now();
    edad = fechaActual.getYear() - fechaNacimiento.getYear();
    documentoIdentidad = documento;
  }

}
