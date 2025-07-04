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
    
    public void reducirInocencia(int cantidad) {
        this.nivelInocencia = Math.max(0, this.nivelInocencia - cantidad);
    }
    
    public void setNervioso(boolean nervioso) {
        this.esNervioso = nervioso;
    }
    
    public void reducirHabilidad(int cantidad) {
        this.nivelHabilidad = Math.max(0, this.nivelHabilidad - cantidad);
    }
    
    public int getNivelInocencia() {
    	return nivelInocencia; 
    	}
    public int getNivelHabilidad() {
    	return nivelHabilidad; 
    	}
    public boolean isNervioso() {
    	return esNervioso; 
    	}
    
    @Override
    public String toString() {
        return String.format("Prófugo[Inocencia: %d, Habilidad: %d, Nervioso: %s]", 
                           nivelInocencia, nivelHabilidad, esNervioso);
    }
}
