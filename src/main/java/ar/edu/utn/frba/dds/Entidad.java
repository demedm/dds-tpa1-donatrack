package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public interface Entidad {
  public String razonSocial = "";
  public List<Mail> mailRepresentantes = new ArrayList<>();
  public List<MedioContacto> mediosContacto = new ArrayList<>();

  // los strings son temporales hasta que definamos una forma mas prolija de definir

  public void setMedioContacto(MedioContacto medioContactoList);

}
