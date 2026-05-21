package ar.edu.utn.frba.dds;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImporterDonantes {

  public List<Donante> importarDonantes(String filePath) {
    String fPath = filePath;
    BufferedReader reader = null;
    String linea = "";
    List<Donante> registroDonantes = new ArrayList<>();

    try {
      reader = new BufferedReader(new FileReader(fPath));
      while((linea = reader.readLine()) != null) {
        Donante donante;
        if(linea.contains("HUMANA")) {
          donante = obtenerPersonaDonante(linea);
          registroDonantes.add(donante);
        }
        if(linea.contains("JURIDICA")) {
          donante = obtenerEntidadDonante(linea);
          registroDonantes.add(donante);
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    finally {
      try {
        reader.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return registroDonantes;
  }

  //TipoPersona,TipoDoc,Documento,Nombre/Razón Social,Email,Teléfono

  private PersonaFisica obtenerPersonaDonante(String linea) {
    String[] campo = linea.split(",");
    String[] nombreCompleto = campo[3].split(" ");
    String nombre = nombreCompleto[0];
    String apellido = nombreCompleto[1];
    Mail mail = new Mail(campo[4]);
    return new PersonaFisica(mail, nombre, apellido, campo[2]);
  }

  private PersonaJuridica obtenerEntidadDonante(String linea) {
    String[] campo = linea.split(",");
    Mail mail = new Mail(campo[4]);
    PersonaFisica representante = new PersonaFisica(mail, "NODEFINIDO", "NODEFINIDO", campo[2]);
    return new PersonaJuridica(campo[3], representante);
  }

}
