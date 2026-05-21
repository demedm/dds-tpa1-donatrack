package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Necesidad {
  private String estado="preparacion";
  public List<Peticion> peticiones = new ArrayList<>();

  public boolean estaPreparado(){
    return estado.equals("listo");
  }

  public void agregarPeticiones(String subclase, int cantidad){
    Peticion p = new Peticion(subclase, cantidad);
    peticiones.add(p); //Voy añadiendo a la lista de la necesidad las distintas peticiones de cosas que tengo
  }

  public List<Peticion> getPeticiones(){
    return peticiones;
  }

  public void pedidoListo(){
    estado = "listo";
  }

  public void pedidoEnEntrega(){
    estado = "enviado";
  }

  public void pedidoRecibido(){
    estado = "recibido";
  }


  public void cumplirNecesidades(GestorDonaciones gestorDonaciones){
    int i=0;
    while(i<peticiones.size()){
      subclase = peticiones.get(i).getCantidad();
      cantidad = peticiones.get(i).getCantidad();
      nuevaCantidad = gestorDonaciones.buscarProducto(subclase,cantidad);
      i++;
    }
    boolean todasCubiertas = peticiones.stream().allMatch(p->p.getCantidad()==0);//Va revisando si ya no queda nada mas qeu pedir en cada una
    if (todasCubiertas){
      this.pedidoListo();
    }
  }
}
