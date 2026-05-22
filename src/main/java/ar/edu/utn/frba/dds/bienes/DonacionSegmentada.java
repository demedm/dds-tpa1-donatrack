package ar.edu.utn.frba.dds.bienes;

import java.util.List;

public class DonacionSegmentada {
  private Subcategoria subcategoria;
  private List<Bien> bienesFiltrados;
  private EstadoDonacion estado;

  public DonacionSegmentada(Subcategoria subcategoria,
                            List<Bien> bienesFiltrados, EstadoDonacion estado) {
    this.subcategoria = subcategoria;
    this.bienesFiltrados = bienesFiltrados;
    this.estado = EstadoDonacion.EN_DEPOSITO;
  }

  public Subcategoria getSubcategoria() {
    return this.subcategoria;
  }

  public void agregarBien(Bien bien) {
    this.bienesFiltrados.add(bien);
  }

}
