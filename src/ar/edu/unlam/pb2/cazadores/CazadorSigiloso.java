package ar.edu.unlam.pb2.cazadores;

import ar.edu.unlam.pb2.profugo.Entorno;
import ar.edu.unlam.pb2.profugo.Profugo;

public class CazadorSigiloso extends Cazador {
    public CazadorSigiloso(String nombre, int experiencia) {
        super(nombre, experiencia);
    }

    @Override
    public boolean puedeCapturar(Profugo profugo, Entorno entorno) {
    	this.intimidar(profugo);
        return this.getExperiencia() > profugo.getNivelInocencia() && profugo.getNivelHabilidad() < 50 ;
    }
}
