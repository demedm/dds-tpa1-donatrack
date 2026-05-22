package ar.edu.utn.frba.dds;

public class PersonaJuridica extends Entidad implements Donante { //persona o donante?
  PersonaFisica personaRepresentante;
  public Mail mailEntidad;
  String rubro;
  String tipo;

  public PersonaJuridica(String razon, Mail mail) {
    razonSocial = razon;
    mailEntidad = mail;
    tipo = getTipoEntidad(razon); //ONG, Gubernamental, Empresa, Institucion
  }

  public void setRepresentante(PersonaFisica representante) {
    personaRepresentante = representante;
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

  //Gubernamental, ONG, Empresa, Institución
  public String getTipoEntidad(String nombreEntidad) {
    if (nombreEntidad.contains("Fundación") || nombreEntidad.contains("Asociación Civil")) {
      return "ONG";
    }
    if (nombreEntidad.contains("S.A.")
        || nombreEntidad.contains("S.R.L.")
        || nombreEntidad.contains("S.A.S.")) {
      return "EMPRESA";
    }
    if (nombreEntidad.contains("Cooperativa")) {
      return "INSTITUCION";
    }
    return "GUBERNAMENTAL";
  }

  @Override
  public String getNombre() {
    return razonSocial;
  }

  @Override
  public Mail getMailContacto() {
    return mailEntidad;
  }

  public void donar() {}

}
