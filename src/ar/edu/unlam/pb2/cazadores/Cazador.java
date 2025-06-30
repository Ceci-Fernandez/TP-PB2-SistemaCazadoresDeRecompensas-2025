package ar.edu.unlam.pb2.cazadores;
import ar.edu.unlam.pb2.profugos.*;
import ar.edu.unlam.pb2.tipos.*;

import java.util.ArrayList;

public class Cazador {
	private String nombre;
    private int nivelExperiencia = 0;
    private TipoCazador tipo;
    private ArrayList<Profugo> capturas;

    public Cazador(String nombre, int nivelExperiencia, TipoCazador tipo) {
        this.nombre = nombre;
        this.nivelExperiencia = nivelExperiencia;
        this.tipo = tipo;
        this.capturas = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getNivelExperiencia() {
        return this.nivelExperiencia;
    }

    public ArrayList<Profugo> getCapturas() {
        return this.capturas;
    }

//    public void capturarProfugo(Profugo profugo) {
//        
//    } No me dio el tiempo para hacerla

    public int cantidadCapturas() {
        return capturas.size();
    }

    @Override
    public String toString() {
        return "Cazador: " + this.nombre + " | Experiencia: " + this.nivelExperiencia +
                " | Capturas: " + this.capturas.size();
    }
}
