package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class RegistroDonante {

  private final List<Donante> donantes = new ArrayList();
  ImportadorDonantes importador = new ImportadorDonantes();

   importador.importarDonantes("donantes.csv");

if(importador.existeMail("ana@mail.com")) {

    Donante d = importador.buscarPorMail("ana@mail.com");

    System.out.println(d);
  }
  public Boolean validarUsuarioExistente(String email) {
    return donantes.stream()
        .anyMatch(donante -> donante.tieneEmail(email));
  }

  public void registrarUsuario(){

  }
}
