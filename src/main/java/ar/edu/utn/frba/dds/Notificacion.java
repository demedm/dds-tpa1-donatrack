package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.medioscontacto.MedioContacto;

import java.time.LocalDateTime;

public class Notificacion {
  private final String destinatario;
  private final String mensaje;
  private final LocalDateTime fechaHora;
  private EstadoNotificacion estado;

  public String getDestinatario() {
    return destinatario;
  }

  public String getMensaje() {
    return mensaje;
  }
  //public EstadoNotificacion getEstado() { return estado; }

  public Notificacion(String destinatario, String mensaje) {
    this.destinatario = destinatario;
    this.mensaje = mensaje;
    this.fechaHora = LocalDateTime.now();
    this.estado = EstadoNotificacion.PENDIENTE; // Nace pendiente
  }

  public static boolean notificar(MedioContacto direccion, String mensaje) {
    return direccion.contactar(new Notificacion(direccion.getMedioContacto(), mensaje));
  }

  public void marcarComoCompletada() {
    this.estado = EstadoNotificacion.COMPLETADA;
  }
}
