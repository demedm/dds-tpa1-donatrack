package ar.edu.utn.frba.dds;

public class NecesidadRecurrente extends Necesidad{
  public int diasAVencer;

  public  NecesidadRecurrente(int diasAVencer){
    super();
    this.diasAVencer = diasAVencer;
  }

  public int getDiasAVencer(){
    return diasAVencer;
  }
}
