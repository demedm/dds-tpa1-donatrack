package ar.edu.utn.frba.dds.donantes;

import ar.edu.utn.frba.dds.Entidad;
import ar.edu.utn.frba.dds.medioscontacto.Mail;
import ar.edu.utn.frba.dds.medioscontacto.MedioContacto;
import ar.edu.utn.frba.dds.medioscontacto.Telefono;
import ar.edu.utn.frba.dds.necesidad.Necesidad;
import java.util.Objects;

public class PersonaJuridica extends Entidad implements Donante { //persona o donante?
  PersonaFisica personaRepresentante;
  public Mail mailEntidad;
  String rubro;
  TipoEntidadJuridica tipo;
  Identificacion documentoIdentificacion;

  public PersonaJuridica(String razon, Mail mail, MedioContacto telefono,
                         String documentoEntidad) {
    razonSocial = razon;
    mailEntidad = mail;
    telefonoContacto = new Telefono(telefono.getMedioContacto());
    tipo = getTipoEntidad(razon); //ONG, Gubernamental, Empresa, Institucion
    documentoIdentificacion = new Identificacion(TipoDocumento.CUIT, documentoEntidad);
  }

  public void setRepresentante(PersonaFisica representante) {
    personaRepresentante = new PersonaFisica(representante.mail, representante.nombre,
        representante.apellido, representante.documentoIdentidad.nroDocumento,
        representante.telefonoContacto);
  }

  public void setRubro(String rubroEntidad) {
    rubro = rubroEntidad.toUpperCase();
  }

  public void setMedioContacto(MedioContacto contacto) {
    mediosContacto.add(contacto);
  }

  //Gubernamental, ONG, Empresa, Institución
  public TipoEntidadJuridica getTipoEntidad(String nombreEntidad) {
    if (nombreEntidad.contains("Fundación") || nombreEntidad.contains("Asociación Civil")) {
      return TipoEntidadJuridica.ONG;
    }
    if (nombreEntidad.contains("S.A.")
        || nombreEntidad.contains("S.R.L.")
        || nombreEntidad.contains("S.A.S.")) {
      return TipoEntidadJuridica.EMPRESA;
    }
    if (nombreEntidad.contains("Cooperativa")) {
      return TipoEntidadJuridica.INSTITUCION;
    }
    return TipoEntidadJuridica.GUBERNAMENTAL;
  }

  @Override
  public String getNombre() {
    return razonSocial;
  }

  @Override
  public Mail getMailContacto() {
    return mailEntidad;
  }

  public boolean actualizarInfo(String nombre, String documento, MedioContacto telefono) {
    boolean actualizado = false;
    if (!(Objects.equals(razonSocial, nombre))) {
      razonSocial = nombre;
      actualizado = true;
    }
    if (!(Objects.equals(documentoIdentificacion.nroDocumento, documento))) {
      documentoIdentificacion.nroDocumento = documento;
      actualizado = true;
    }
    if (!(Objects.equals(telefonoContacto.getMedioContacto(), telefono.getMedioContacto()))) {
      telefonoContacto.nroTelefono = telefono.getMedioContacto();
      actualizado = true;
    }
    return actualizado;
  }

  @Override
  public Identificacion getDocumento() {
    return documentoIdentificacion;
  }

  @Override
  public Telefono getTelefonoContacto() {
    return telefonoContacto;
  }

  public Necesidad donar() {
    return null;
  }

}
