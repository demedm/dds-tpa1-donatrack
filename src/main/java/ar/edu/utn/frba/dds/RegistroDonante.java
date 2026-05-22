package ar.edu.utn.frba.dds;

import static ar.edu.utn.frba.dds.ImporterDonantes.registroDonantes;

public class RegistroDonante {

  public void registrarDonante(Donante nuevoDonante) {

    Donante existente = ImporterDonantes.buscarPorEmail(nuevoDonante.getMailContacto().direccionMail);

    if(existente != null) {
      existente.actualizarInfo(nuevoDonante.getNombre(), nuevoDonante.getDocumento().toString(), nuevoDonante.getTelefonoContacto());
      System.out.println("Donante actualizado");
    } else {
      registroDonantes.add(nuevoDonante);
      System.out.println("Nuevo donante registrado");
    }
  }
}
