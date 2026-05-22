package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Necesidad {
  private String estado = "preparacion";
  public List<Peticion> peticiones = new ArrayList<>();

  public boolean estaPreparado() {
    return estado.equals("listo");
  }

  public void agregarPeticiones(String subclase, int cantidad) {
    Peticion p = new Peticion(subclase, cantidad);
    peticiones.add(p);
    //Voy aniadiendo a la lista de la necesidad las distintas peticiones de cosas que tengo
  }

  public List<Peticion> getPeticiones() {
    return peticiones;
  }

  public String getEstado() {
    return estado;
  }

  public void pedidoListo() {
    estado = "listo";
  }

  public void pedidoEnEntrega() {
    estado = "enviado";
  }

  public void pedidoRecibido() {
    estado = "recibido";
  }


  public void cumplirNecesidades(GestorDonaciones gestorDonaciones) {
    int i = 0;
    while (i < peticiones.size()) {
      String subclase = peticiones.get(i).getSubclase();
      int cantidad = peticiones.get(i).getCantidad();
      int nuevaCantidad = gestorDonaciones.buscarProducto(subclase, cantidad);
      peticiones.get(i).setCantidad(nuevaCantidad);
      i++;
    }
    //Va revisando si ya no queda nada mas qeu pedir en cada una
    boolean todasCubiertas = peticiones.stream().allMatch(p -> p.getCantidad() == 0);
    if (todasCubiertas) {
      this.pedidoListo();
    }
  }
}
