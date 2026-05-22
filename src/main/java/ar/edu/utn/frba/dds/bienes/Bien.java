package ar.edu.utn.frba.dds.bienes;

public class Bien {
  private String descripcion;
  private String foto;
  private Subcategoria subcategoria;
  private Integer cantidad;
  private Caracteristica caracteristica;
  private EstadoDonacion estado = EstadoDonacion.EN_DEPOSITO;

  public Bien(String descripcion, String foto, Subcategoria subcategoria,
              Integer cantidad, Caracteristica caracteristica) {
    this.descripcion = descripcion;
    this.foto = foto;
    this.subcategoria = subcategoria;
    this.cantidad = cantidad;
    this.caracteristica = caracteristica;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }
  public void setEstado(EstadoDonacion estado) { this.estado = estado; }

  public Bien copia(int nuevaCantidad, EstadoDonacion estado) {
    Bien b = new Bien(descripcion, foto, subcategoria, nuevaCantidad, caracteristica);
    b.setEstado(estado);
    return b;
  }

  public Subcategoria getSubcategoria() {
    return this.subcategoria;
  }

  public Caracteristica getCaracteristica() {
    return this.caracteristica;
  }

}



