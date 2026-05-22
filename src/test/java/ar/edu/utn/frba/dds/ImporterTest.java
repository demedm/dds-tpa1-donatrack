package ar.edu.utn.frba.dds;

import static org.junit.jupiter.api.Assertions.*;
import ar.edu.utn.frba.dds.donantes.Donante;
import ar.edu.utn.frba.dds.donantes.PersonaFisica;
import ar.edu.utn.frba.dds.donantes.PersonaJuridica;
import ar.edu.utn.frba.dds.medioscontacto.Mail;
import ar.edu.utn.frba.dds.medioscontacto.MedioContacto;
import ar.edu.utn.frba.dds.medioscontacto.Telefono;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImporterTest {

  @Test
  public void importaCorrectamentedelCSV() {
    String nombreUltimoDonante = donanteList.get(donanteList.size() - 1).getNombre();
    String[] nombreCompleto = nombreUltimoDonante.split(" ");
    assertEquals(nombreCompleto[0], lastDonante().nombre);
    String nombreDonante = donanteList.get(5).getNombre();
    String[] nombre = nombreDonante.split(" ");
    assertEquals(nombre[0], julieta().nombre);
  }

  @Test
  public void actualizaCorrectamente() {
    setHistorial(historial);
    ImporterDonantes.actualizarDonantes(historial, path);
    assert(!Objects.equals(historial.get(1).getTelefonoContacto().getMedioContacto(), "00"));
  }

  String path = "src/main/java/ar/edu/utn/frba/dds/donantes_import_20000_UTF8_BOM.csv";
  private List<Donante> donanteList = ImporterDonantes.importarDonantes(path);
  private List<Donante> historial = new ArrayList<>();

  private void setHistorial(List<Donante> historial) {
    historial.add(julieta());
    santaFeIndustrial().telefonoContacto.nroTelefono = "00";
    historial.add(santaFeIndustrial());
    historial.add(lastDonante());
    historial.add(yoCoopetiva());
  }

  private PersonaJuridica yoCoopetiva() {
    Mail mail = new Mail("yocooperativa8180@yahoo.com");
    MedioContacto telefono = new Telefono("+54 11 4724-2300");
    return new PersonaJuridica("Yo Cooperativa", mail, telefono, "1111");
  }

  //HUMANA,DNI,47376264,Julieta Romero,julietaromero5314@yahoo.com,+54 11 5305-6413
  private PersonaFisica julieta() {
    Mail mail = new Mail("julietaromero5314@yahoo.com");
    MedioContacto telefono = new Telefono("+54 11 5305-6413");
    return new PersonaFisica(mail, "Julieta", "Romero",
        "47376264", telefono);
  }

  //JURIDICA,CUIT,30-52235350-3,Santa Fe Industrial Fundación,santafeindustrial8180@yahoo.com,+54 11 4724-2388
  private PersonaJuridica santaFeIndustrial() {
    Mail mail = new Mail("santafeindustrial8180@yahoo.com");
    MedioContacto telefono = new Telefono("+54 11 4724-2388");
    return new PersonaJuridica("Santa Fe Industrial", mail, telefono, "30-52235350-3");
  }

  //HUMANA,DNI,39421367,María Aguirre,maríaaguirre4360@outlook.com,+54 11 4848-1579
  private PersonaFisica lastDonante() {
    Mail mail = new Mail("maríaaguirre4360@outlook.com");
    MedioContacto telefono = new Telefono("+54 11 4848-1579");
    PersonaFisica maria = new PersonaFisica(mail, "María", "Aguirre",
        "39421367", telefono);
    return maria;
  }

}
