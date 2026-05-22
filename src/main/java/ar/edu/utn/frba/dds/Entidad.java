package ar.edu.utn.frba.dds;

import java.util.List;

public class Entidad {
  public String razonSocial;
  public List<MedioContacto> mediosContacto;
  public MedioContacto contactoParaNotificaciones;
  public List<Mail> mailRepresentantes;

  // los strings son temporales hasta que definamos una forma mas prolija de definir

  public Entidad(String razon, List<Mail> mailList) {
    razonSocial = razon;
    mailRepresentantes = mailList;
  }

  public void setMedioContacto(List<MedioContacto> medioContactoList) {
    mediosContacto = medioContactoList;
  }

}
