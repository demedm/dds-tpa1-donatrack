package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.donantes.Donante;
import ar.edu.utn.frba.dds.donantes.PersonaFisica;
import ar.edu.utn.frba.dds.donantes.PersonaJuridica;
import ar.edu.utn.frba.dds.medioscontacto.Mail;
import ar.edu.utn.frba.dds.medioscontacto.MedioContacto;
import ar.edu.utn.frba.dds.medioscontacto.Telefono;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImporterDonantes {

  // info basica de contacto: documento, nombre, email, telefono
  public static void actualizarDonantes(List<Donante> registroDonantesActualizar, String filePath) {
    List<Donante> nuevosDonantes = importarDonantes(filePath);
    boolean actualizado = false;
    for (Donante donante : nuevosDonantes) {
      for (Donante posibleDesactualizado : registroDonantesActualizar) {
        if (Objects.equals(posibleDesactualizado.getMailContacto().getMedioContacto(),
            donante.getMailContacto().getMedioContacto())) {
          actualizado = posibleDesactualizado.actualizarInfo(donante.getNombre(),
              donante.getDocumento().getNroDocumento(), donante.getMailContacto());
        }
      }
      if (actualizado) {
        registroDonantesActualizar.add(donante);
      }
    }
  }

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
        if (reader != null) {
          reader.close();
        }
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
    MedioContacto telefono = new Telefono(campo[5]);
    return new PersonaFisica(mail, nombre, apellido, campo[2], telefono);
  }

  private static PersonaJuridica obtenerEntidadDonante(String linea) {
    String[] campo = linea.split(",");
    Mail mailEntidad = new Mail(campo[4]);
    MedioContacto telefono = new Telefono(campo[5]);
    return new PersonaJuridica(campo[3], mailEntidad, telefono, campo[2]);
  }

}
