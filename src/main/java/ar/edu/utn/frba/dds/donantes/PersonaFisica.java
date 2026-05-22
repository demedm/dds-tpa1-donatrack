package ar.edu.utn.frba.dds.donantes;

import ar.edu.utn.frba.dds.medioscontacto.Mail;
import ar.edu.utn.frba.dds.medioscontacto.MedioContacto;
import ar.edu.utn.frba.dds.medioscontacto.Telefono;
import ar.edu.utn.frba.dds.necesidad.Necesidad;
import java.time.LocalDate;
import java.util.Objects;

public class PersonaFisica implements Donante {
  public Mail mail;
  public String nombre;
  public String apellido;
  private int edad;
  private Genero genero;
  public Telefono telefonoContacto;
  public String direccionActual;
  public Identificacion documentoIdentidad = null;  // algo mejor que esta forma

  public PersonaFisica(Mail email, String nombrePersona, String apellidoPersona,
                       String documento, MedioContacto telefono) {
    mail = email;
    nombre = nombrePersona;
    apellido = apellidoPersona;
    documentoIdentidad = new Identificacion(TipoDocumento.DNI, documento);
    telefonoContacto = new Telefono(telefono.getMedioContacto());
  }

  public void setEdad(LocalDate fechaNacimiento) {
    LocalDate fechaActual = LocalDate.now();
    edad = fechaActual.getYear() - fechaNacimiento.getYear();
  }

  public void setGenero(String gen) {
    var gender = gen.toUpperCase();
    if (gen.contains("HOMBRE")) {
      genero = Genero.HOMBRE;
      return;
    }
    if (gen.contains("MUJER")) {
      genero = Genero.MUJER;
    }
    genero = Genero.OTRO;
  }

  public void setDireccion(String direccion) {
    direccionActual = direccion.toUpperCase();
  }

  @Override
  public String getNombre() {
    return nombre + " " + apellido;
  }

  @Override
  public Mail getMailContacto() {
    return mail;
  }

  @Override
  public boolean actualizarInfo(String name, String documento, MedioContacto telefono) {
    boolean actualizado = false;
    if (!(Objects.equals(nombre, name))) {
      nombre = name;
      actualizado = true;
    }
    if (!(Objects.equals(documentoIdentidad.nroDocumento, documento))) {
      documentoIdentidad.nroDocumento = documento;
      actualizado = true;
    }
    if (!(Objects.equals(telefonoContacto.nroTelefono, telefono.getMedioContacto()))) {
      telefonoContacto.nroTelefono = telefonoContacto.getMedioContacto();
      actualizado = true;
    }
    return actualizado;
  }

  @Override
  public Identificacion getDocumento() {
    return documentoIdentidad;
  }

  @Override
  public Telefono getTelefonoContacto() {
    return telefonoContacto;
  }

  @Override
  public void donar(String descripcion, String pathFoto, List<Bien> bienes) {
    Bien nuevoBien = bienes;
    Donacion nuevaDonacion = new Donacion(descripcion, this, bienes);
    GestorDonaciones.agregarDonacion(nuevaDonacion);
  }

}
