package ar.edu.utn.frba.dds.bienes;

import java.util.Date;

public class BienPerecedero extends Bien {
  private Date fechaVencimiento;

  public BienPerecedero(Subcategoria subCategoria, Integer cantidad, String foto,
                        String descripcion, Date fechaVencimiento) {
    super(descripcion, foto, subCategoria, cantidad);
    this.fechaVencimiento = fechaVencimiento;
  }
}