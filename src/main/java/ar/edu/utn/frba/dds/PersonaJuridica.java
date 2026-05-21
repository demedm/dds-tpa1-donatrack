package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class PersonaJuridica extends Entidad implements Donante { //persona o donante?
  PersonaFisica personaRepresentante;
  String rubro;
  String tipo;

  public PersonaJuridica(String razon, String tipoEntidad, String rubroEntidad, PersonaFisica representante, List<Mail> mailRepresentante) {
    super(razon, mailRepresentante);
    personaRepresentante = representante;
    tipo = tipoEntidad; //ONG, Gubernamental, Empresa, Institucion
    rubro = rubroEntidad;
  }

  public void donar() {}

}
