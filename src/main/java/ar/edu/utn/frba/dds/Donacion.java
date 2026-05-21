package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Donacion {
  private EstadoDonacion estadoActual;
  private String justificacionFallo;
  private final List<RegistroCambioEstado> historialEstados = new ArrayList<>();

  public Donacion() {
    this.estadoActual = new EnDeposito();
  }

  public void setEstado(EstadoDonacion nuevoEstado) {
    this.estadoActual = nuevoEstado;
    this.historialEstados.add(new RegistroCambioEstado(nuevoEstado.getNombre(), LocalDateTime.now()));
  }

  public void setJustificacionFallo(String justificacion) {
    this.justificacionFallo = justificacion;
  }
  public List<RegistroCambioEstado> getHistorialEstados() {
    return historialEstados;}
  
  public void asignar() { estadoActual.asignar(this); }
  public void planificarRuta() { estadoActual.planificarRuta(this); }
  public void iniciarTraslado() { estadoActual.iniciarTraslado(this); }
  public void confirmarEntrega() { estadoActual.confirmarEntrega(this); }
  public void fallarEntrega(String justificacion) { estadoActual.fallarEntrega(this, justificacion); }
  public void vencer() { estadoActual.vencer(this); }
  public String getNombreEstado() { return estadoActual.getNombre(); }
}
