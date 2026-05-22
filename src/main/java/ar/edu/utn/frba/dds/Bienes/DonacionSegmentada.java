package ar.edu.utn.frba.dds.Bienes;

import ar.edu.utn.frba.dds.EntidadBeneficiaria;

import java.util.List;

public class DonacionSegmentada {
  private int cantidad;
  private Subcategoria subcategoria;
  private List<Bien> bienesFiltrados;
  private EstadoDonacion estado;

  public DonacionSegmentada(Integer cantidad, Subcategoria subcategoria, List<Bien> bienesFiltrados) {
    this.cantidad = cantidad;
    this.subcategoria = subcategoria;
    this.bienesFiltrados = bienesFiltrados;
    this.estado = EstadoDonacion.EN_DEPOSITO;
  }

  public void donar(EntidadBeneficiaria entidad ){
    
  }
}
