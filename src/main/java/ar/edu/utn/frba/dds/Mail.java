package ar.edu.utn.frba.dds;

public class Mail implements MedioContacto {
  String direccionMail;

  public Mail(String direccionCasilla) {
    if (direccionCasilla.contains("@") && direccionCasilla.contains(".com")) {
      direccionMail = direccionCasilla;
    }
  }

  @Override
  public String getMedioContacto() {
    return direccionMail;
  }

  public void contactar() {

  }

}
