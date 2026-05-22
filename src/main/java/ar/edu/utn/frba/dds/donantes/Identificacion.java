package ar.edu.utn.frba.dds.donantes;

public class Identificacion {
  TipoDocumento tipo;
  String nroDocumento;

  public Identificacion(TipoDocumento t, String nro) {
    tipo = t;
    nroDocumento = nro;
  }

  public String getNroDocumento() {
    return nroDocumento;
  }

  public TipoDocumento getTipo() {
    return tipo;
  }

}
