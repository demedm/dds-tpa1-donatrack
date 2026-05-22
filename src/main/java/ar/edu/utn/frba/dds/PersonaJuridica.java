package ar.edu.utn.frba.dds;

public class PersonaJuridica extends Entidad {
  PersonaFisica personaRepresentante;

  public PersonaJuridica(String razon, String tipoEntidad,
                         String rubroEntidad, PersonaFisica representante) {
    super(razon, tipoEntidad, rubroEntidad);
    personaRepresentante = representante;
  }

}
