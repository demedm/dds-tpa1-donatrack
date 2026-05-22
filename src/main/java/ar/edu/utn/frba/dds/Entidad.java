package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.medioscontacto.Mail;
import ar.edu.utn.frba.dds.medioscontacto.MedioContacto;
import ar.edu.utn.frba.dds.medioscontacto.Telefono;
import java.util.ArrayList;
import java.util.List;

public abstract class Entidad {
  public String razonSocial = "";
  public List<Mail> mailRepresentantes = new ArrayList<>();
  public Telefono telefonoContacto;
  public List<MedioContacto> mediosContacto = new ArrayList<>();

  // los strings son temporales hasta que definamos una forma mas prolija de definir

  public void setMedioContacto(MedioContacto contacto) {
    mediosContacto.add(contacto);
  }

}
