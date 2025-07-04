package ar.edu.unlam.pb2.profugo;

public class Profugo {
 
    private Integer nivelInocencia ;
    private Integer nivelHabilidad;
    private Boolean esNervioso ;

    public Profugo( Integer nivelInocencia, Integer nivelHabilidad, Boolean nervioso) {
    	
    	  if (nivelHabilidad < 1 || nivelHabilidad > 100) {
              throw new IllegalArgumentException("El nivel de habilidad debe estar entre 1 y 100");
          }
          if (nivelInocencia < 0) {
              throw new IllegalArgumentException("El nivel de inocencia no puede ser negativo");
          }
       this.nivelHabilidad= nivelHabilidad;
        this.nivelInocencia = nivelInocencia;
        this.esNervioso = nervioso;
    }
    
    
    public Integer getNivelInocencia() {
        return nivelInocencia;
    }

    public Integer getNivelHabilidad() {
        return nivelHabilidad;
    }

    public Boolean isNervioso() {
        return esNervioso;
    }

    public void reducirInocencia(Integer cantidad) {
        this.nivelInocencia = Math.max(0, this.nivelInocencia - cantidad);
    }
    

    public void reducirHabilidad(Integer cantidad) {
        this.nivelHabilidad = Math.max(0, this.nivelHabilidad - cantidad);
    }
    

    public void setNervioso(Boolean nervioso) {
        this.esNervioso = nervioso;
    }


    @Override
    public String toString() {
        return " - Inocencia: " + this.nivelInocencia +
               " - Habilidad: " + this.nivelHabilidad +
               " - Intimidado: " + this.esNervioso ;
    }
}