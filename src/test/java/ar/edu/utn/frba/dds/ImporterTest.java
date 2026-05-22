package ar.edu.utn.frba.dds;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

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

  private List<Donante> donanteList = ImporterDonantes.importarDonantes("src/main/java/ar/edu/utn/frba/dds/donantes_import_20000_UTF8_BOM.csv");

  //HUMANA,DNI,47376264,Julieta Romero,julietaromero5314@yahoo.com,+54 11 5305-6413
  private PersonaFisica julieta() {
    Mail mail = new Mail("julietaromero5314@yahoo.com");
    return new PersonaFisica(mail, "Julieta", "Romero", "47376264");
  }

  //JURIDICA,CUIT,30-52235350-3,Santa Fe Industrial Fundación,santafeindustrial8180@yahoo.com,+54 11 4724-2388
  private PersonaJuridica santaFeIndustrial() {
    Mail mail = new Mail("santafeindustrial8180@yahoo.com");
    return new PersonaJuridica("Santa Fe Industrial", mail);
  }

  //HUMANA,DNI,39421367,María Aguirre,maríaaguirre4360@outlook.com,+54 11 4848-1579
  private PersonaFisica lastDonante() {
    Mail mail = new Mail("maríaaguirre4360@outlook.com");
    PersonaFisica maria = new PersonaFisica(mail, "María", "Aguirre", "39421367");
    return maria;
  }

}
