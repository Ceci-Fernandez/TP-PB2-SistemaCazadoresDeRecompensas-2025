package ar.edu.unlam.pb2.profugos;

public class Profugo {
    private String nombre;
    private int nivel_peligro = 0;
    private boolean capturado;

    public Profugo(String nombre, int nivel_peligro) {
        this.nombre = nombre;
        this.nivel_peligro = nivel_peligro;
        this.capturado = false; 
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getNivel_Peligro() {
        return this.nivel_peligro;
    }

    public boolean estaCapturado() {
        return this.capturado;
    }

    public void capturar() {
        this.capturado = true;
    }

    @Override
    public String toString() {
        return "Prófugo: " + this.nombre + " | Peligrosidad: " + this.nivel_peligro +
                " | Capturado: " + this.capturado;
    }
}