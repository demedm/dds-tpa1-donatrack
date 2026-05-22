package ar.edu.utn.frba.dds;

public class Entidad {
  public String razonSocial;
  public String tipo;
  public String rubro;

  // los strings son temporales hasta que definamos una forma mas prolija de definir
  public Entidad(String razon, String tipoEntidad, String rubro) {
    razonSocial = razon;
    tipo = tipoEntidad;
    this.rubro = rubro;
  }

  public Entidad(String razon, String tipoEntidad) {
    razonSocial = razon;
    tipo = tipoEntidad;
    this.rubro = "";
  }
}
