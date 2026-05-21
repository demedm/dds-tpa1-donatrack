package ar.edu.utn.frba.dds;

public class PersonaJuridica extends Donante implements Entidad { //persona o donante?
  PersonaFisica personaRepresentante;
  String rubro;
  String tipo;

  public PersonaJuridica(String razon, PersonaFisica representante) {
    razonSocial.copyValueOf(razon.toCharArray());
    personaRepresentante = representante;
    mailRepresentantes.add(representante.mail);
    tipo = getTipoEntidad(razon); //ONG, Gubernamental, Empresa, Institucion
  }

  public void setRubro(String rubroEntidad) {
    rubro = rubroEntidad.toUpperCase();
  }

  public void setPersonaRepresentante(PersonaFisica representante) {
    personaRepresentante = representante;
  }

  public void setMedioContacto(MedioContacto contacto) {
    mediosContacto.add(contacto);
  }

  public String getTipoEntidad(String nombreEntidad) {
    return "";
  }

  public void donar() {}

}
