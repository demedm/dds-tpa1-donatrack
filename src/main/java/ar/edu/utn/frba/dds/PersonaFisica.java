package ar.edu.utn.frba.dds;

import java.time.LocalDate;

public class PersonaFisica implements Donante {
  public Mail mail;
  public String nombre;
  public String apellido;
  private int edad;
  private String genero;
  public String direccionActual;
  private String documentoIdentidad;  // algo mejor que esta forma

  public PersonaFisica(Mail email, String nombrePersona, String apellidoPersona,
                       String documento) {
    mail = email;
    nombre = nombrePersona;
    apellido = apellidoPersona;
    documentoIdentidad = documento;
  }

  public void setEdad(LocalDate fechaNacimiento) {
    LocalDate fechaActual = LocalDate.now();
    edad = fechaActual.getYear() - fechaNacimiento.getYear();
  }

  public void setGenero(String gen) {
    var gender = gen.toUpperCase();
    if (gen.contains("HOMBRE") || gen.contains("MUJER") || gen.contains("OTRO")) {
      genero = gender;
      return;
    }
    genero = "NODEFINIDO";
  }

  public void setDireccion(String direccion) {
    direccion.toUpperCase();
    direccionActual = direccion;
  }

  @Override
  public String getNombre() {
    return nombre + " " + apellido;
  }

  @Override
  public Mail getMailContacto() {
    return mail;
  }

  public void donar() {}

}
