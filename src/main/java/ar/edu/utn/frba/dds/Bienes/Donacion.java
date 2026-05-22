package ar.edu.utn.frba.dds.Bienes;

import ar.edu.utn.frba.dds.Donante;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Donacion {
  private String descripcionGeneral;
  private List<DonacionSegmentada> donacionesSegmentadas;
  private Donante donante;

  public Donacion(String descripcionGeneral, List<Bien> bienes, Donante donante) {
    this.descripcionGeneral = descripcionGeneral;
    this.donacionesSegmentadas = this.segmentar(bienes);
    this.donante = donante;
  }

  private List<DonacionSegmentada> segmentar(List<Bien> bienes) {
    Map<Criterio, List<Bien>> agrupados = bienes.stream()
        .collect(Collectors.groupingBy(Bien::getClaveAgrupacion));

    return agrupados.entrySet().stream()
        .map(entry -> new DonacionSegmentada(
            entry.getValue().size(), //
            entry.getKey().subcategoria(),
            entry.getValue()
        ))
        .collect(Collectors.toList());
  }

}
