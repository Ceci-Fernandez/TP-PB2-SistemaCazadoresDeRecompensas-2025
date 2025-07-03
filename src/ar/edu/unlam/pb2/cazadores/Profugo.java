package ar.edu.unlam.pb2.cazadores;

public class Profugo {
    private String nombre;
    private int nivelInocencia = 0;
    private int nivelHabilidad = 0;
    private boolean nervioso = false;

    public Profugo(String nombre, int nivelInocencia, int nivelHabilidad, boolean nervioso) {
        this.nombre = nombre;
        this.nivelInocencia = nivelInocencia;
        setNivelHabilidad(nivelHabilidad); 
        this.nervioso = nervioso;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getNivelInocencia() {
        return nivelInocencia;
    }

    public int getNivelHabilidad() {
        return nivelHabilidad;
    }

    public boolean isNervioso() {
        return nervioso;
    }

    public void setNivelInocencia(int nuevoValor) {
        if (nuevoValor < 40) { 
            this.nivelInocencia = 40;
        } else {
            this.nivelInocencia = nuevoValor;
        }
    }

    public void setNivelHabilidad(int nivelHabilidad) {
        if (nivelHabilidad > 100) {
            this.nivelHabilidad = 100;
        } else if (nivelHabilidad < 0) {
            this.nivelHabilidad = 0;
        } else {
            this.nivelHabilidad = nivelHabilidad;
        }
    }

    public void setNervioso(boolean nervioso) {
        this.nervioso = nervioso;
    }


    @Override
    public String toString() {
        return this.nombre + " - Inocencia: " + this.nivelInocencia +
               " - Habilidad: " + this.nivelHabilidad +
               " - Intimidado: " + this.nervioso ;
    }
}