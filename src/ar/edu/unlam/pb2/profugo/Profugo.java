package ar.edu.unlam.pb2.profugo;

public class Profugo {

    protected Integer nivelInocencia;
    protected Integer nivelHabilidad;
    protected Boolean esNervioso;
    

    public Profugo(Integer nivelInocencia, Integer nivelHabilidad, Boolean esNervioso) {
        if (nivelHabilidad < 1 || nivelHabilidad > 100) {
            throw new IllegalArgumentException("El nivel de habilidad debe estar entre 1 y 100");
        }
        if (nivelInocencia < 0) {
            throw new IllegalArgumentException("El nivel de inocencia no puede ser negativo");
        }
        
        this.nivelInocencia = nivelInocencia;
        this.nivelHabilidad = nivelHabilidad;
        this.esNervioso = esNervioso;
    }
    
    public void reducirInocencia(Integer cantidad) {
        this.nivelInocencia = Math.max(0, this.nivelInocencia - cantidad);
    }
    
    public void setNervioso(Boolean nervioso) {
        this.esNervioso = nervioso;
    }
    
    public void reducirHabilidad(Integer cantidad) {
        this.nivelHabilidad = Math.max(0, this.nivelHabilidad - cantidad);
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
    
    @Override
    public String toString() {
        return String.format("Prófugo[Inocencia: %d, Habilidad: %d, Nervioso: %s]", 
                           nivelInocencia, nivelHabilidad, esNervioso);
    }
}
