package ar.edu.utn.frba.dds.bienes;

public class Bien {
  private String descripcion;
  private String foto;
  private Subcategoria subcategoria;
  private Integer cantidad;

  private Caracteristica caracteristica;

  public Bien(String descripcion, String foto, Subcategoria subcategoria,
              Integer cantidad, Caracteristica caracteristica) {
    this.descripcion = descripcion;
    this.foto = foto;
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



