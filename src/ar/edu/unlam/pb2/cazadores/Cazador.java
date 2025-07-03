package ar.edu.unlam.pb2.cazadores;

import ar.edu.unlam.pb2.*;
import ar.edu.unlam.pb2.tipos.Entorno;

import java.util.ArrayList;
import java.util.List;

public abstract class Cazador {
    protected String nombre;
    protected int experiencia;
    protected List<Profugo> capturados;

    public Cazador(String nombre, int experiencia) {
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.capturados = new ArrayList<>();
    }

    public void registrarCaptura(Profugo progufo) {
        capturados.add(progufo);
    }

    public List<Profugo> getCapturados() {
        return capturados;
    }

    public String getNombre() {
        return nombre;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void intimidar(Profugo profugo) {
        profugo.setNivelInocencia(profugo.getNivelInocencia() - 2);
    }

	public boolean puedeCapturar(Profugo profugo, Entorno entorno) {
		// TODO Auto-generated method stub
		return false;
	}
}