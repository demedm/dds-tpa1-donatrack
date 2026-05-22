package ar.edu.utn.frba.dds.Bienes;

public class BienDuradero extends Bien {
  private EstadoUso estado;

  public BienDuradero(Subcategoria subCategoria, Integer cantidad, String foto, String descripcion, EstadoUso estado) {
    super(subCategoria, cantidad, foto, descripcion);
    this.estado = estado;
  }

  @Override
  public Object getCriterioSegmentacion() {
    return this.estado;
  }
  
}
