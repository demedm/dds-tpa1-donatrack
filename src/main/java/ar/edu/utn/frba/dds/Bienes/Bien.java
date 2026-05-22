package ar.edu.utn.frba.dds.Bienes;

public class Bien {
  private String Descripcion;
  private String Foto;
  private Subcategoria subcategoria;
  private Integer cantidad;

  private Caracteristica caracteristica;

  public Bien(String descripcion, String foto, Subcategoria subcategoria, Integer cantidad, Caracteristica caracteristica) {
    Descripcion = descripcion;
    Foto = foto;
    this.subcategoria = subcategoria;
    this.cantidad = cantidad;
    this.caracteristica = caracteristica;
  }

  public Subcategoria getSubcategoria() {
    return this.subcategoria;
  }

  public Caracteristica getCaracteristica() {
    return this.caracteristica;
  }

}



