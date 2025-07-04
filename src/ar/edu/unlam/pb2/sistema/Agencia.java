package ar.edu.unlam.pb2.sistema;

import ar.edu.unlam.pb2.cazadores.*;
import ar.edu.unlam.pb2.excepciones.CazadorException;
import ar.edu.unlam.pb2.profugo.*;
import java.util.*;


public class Agencia {
	private Map<String, Cazador> cazadores; 
	private Map<String, Zona> zonas; 
	private List<Profugo> historialCapturas;


	public Agencia() {
		this.cazadores = new HashMap<>();
		this.zonas = new HashMap<>();
		this.historialCapturas = new ArrayList<>();
	}


	public void registrarCazador(Cazador cazador) {
		if (cazador == null) {
			throw new CazadorException("El cazador no puede ser null");
		}
		if (cazadores.containsKey(cazador.getNombre())) {
			throw new CazadorException("Ya existe un cazador con el nombre: " + cazador.getNombre());
		}
		cazadores.put(cazador.getNombre(), cazador);
	}

	public void registrarZona(Zona zona) {
		if (zona == null) {
			throw new IllegalArgumentException("La zona no puede ser null");
		}
		if (zonas.containsKey(zona.getNombre())) {
			throw new IllegalArgumentException("Ya existe una zona con el nombre: " + zona.getNombre());
		}
		zonas.put(zona.getNombre(), zona);
	}


	public void enviarCazadorAZona(String nombreCazador, String nombreZona) {
		Cazador cazador = cazadores.get(nombreCazador);
		Zona zona = zonas.get(nombreZona);

		if (cazador == null) {
			throw new CazadorException("No se encontró el cazador: " + nombreCazador);
		}
		if (zona == null) {
			throw new IllegalArgumentException("No se encontró la zona: " + nombreZona);
		}


		int capturasAntes = cazador.getCantidadCapturas();


		cazador.realizarCaptura(zona);


		List<Profugo> nuevasCapturas = cazador.getProfugosCapturados()
				.subList(capturasAntes, cazador.getCantidadCapturas());
		historialCapturas.addAll(nuevasCapturas);
	}


	public List<Profugo> obtenerTodosLosProfugosCapturados() {
		return new ArrayList<>(historialCapturas);
	}

	public Profugo obtenerProfugoMasHabilCapturado() {
		if (historialCapturas.isEmpty()) {
			return null; 
		}

		Profugo profugoMasHabil = historialCapturas.get(0);


		for (Profugo profugo : historialCapturas) {
			if (profugo.getNivelHabilidad() > profugoMasHabil.getNivelHabilidad()) {
				profugoMasHabil = profugo;
			}
		}

		return profugoMasHabil;
	}


	public Cazador obtenerCazadorConMasCapturas() {
		if (cazadores.isEmpty()) {
			return null; 
		}

		Cazador cazadorConMasCapturas = null;
		int maxCapturas = -1;


		for (Cazador cazador : cazadores.values()) {
			if (cazador.getCantidadCapturas() > maxCapturas) {
				maxCapturas = cazador.getCantidadCapturas();
				cazadorConMasCapturas = cazador;
			}
		}

		return cazadorConMasCapturas;
	}

	public Integer getTotalCazadores() {
		return cazadores.size();
	}

	public int getTotalZonas() {
		return zonas.size();
	}

	public int getTotalCapturas() {
		return historialCapturas.size();
	}

	public int getProfugosRestantesEnTodasLasZonas() {
		int total = 0;

		for (Zona zona : zonas.values()) {
			total += zona.getCantidadProfugos();
		}
		return total;
	}


	public Collection<Cazador> getCazadores() {
		return new ArrayList<>(cazadores.values());
	}

	public Collection<Zona> getZonas() {
		return new ArrayList<>(zonas.values());
	}

	public Cazador getCazador(String nombre) {
		return cazadores.get(nombre);
	}

	public Zona getZona(String nombre) {
		return zonas.get(nombre);
	}
}
