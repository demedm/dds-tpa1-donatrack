package ar.edu.utn.frba.dds;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ImporterDonantes {

  public static List<Donante> importarDonantes(String filePath) {
    String fpath = filePath;
    BufferedReader reader = null;
    String linea = "";
    List<Donante> registroDonantes = new ArrayList<>();

    try {
      reader = new BufferedReader(new InputStreamReader(
          new FileInputStream(fpath), StandardCharsets.UTF_8));
      while ((linea = reader.readLine()) != null) {
        Donante donante;
        if (linea.contains("HUMANA")) {
          donante = obtenerPersonaDonante(linea);
          registroDonantes.add(donante);
        }
        if (linea.contains("JURIDICA")) {
          donante = obtenerEntidadDonante(linea);
          registroDonantes.add(donante);
        }

      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      try {
        reader.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return registroDonantes;
  }

  //TipoPersona,TipoDoc,Documento,Nombre/Razón Social,Email,Teléfono

  private static PersonaFisica obtenerPersonaDonante(String linea) {
    String[] campo = linea.split(",");
    String[] nombreCompleto = campo[3].split(" ");
    String nombre = nombreCompleto[0];
    String apellido = nombreCompleto[1];
    Mail mail = new Mail(campo[4]);
    return new PersonaFisica(mail, nombre, apellido, campo[2]);
  }

  private static PersonaJuridica obtenerEntidadDonante(String linea) {
    String[] campo = linea.split(",");
    Mail mailEntidad = new Mail(campo[4]);
    return new PersonaJuridica(campo[3], mailEntidad);
  }

}
