package ar.edu.unlam.pb2.cazadores;

import ar.edu.unlam.pb2.profugo.Profugo;
import ar.edu.unlam.pb2.sistema.Zona;

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

    public void intimidarProfugo(Profugo profugo) {
       
    }

	public boolean puedeCapturar(Profugo profugo) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getCantidadCapturas() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void realizarCaptura(Zona zona) {
		// TODO Auto-generated method stub
		
	}

	public List<Profugo> getProfugosCapturados() {
		// TODO Auto-generated method stub
		return null;
	}
}