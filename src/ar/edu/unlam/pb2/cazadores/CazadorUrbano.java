package ar.edu.unlam.pb2.cazadores;

import ar.edu.unlam.pb2.profugo.Entorno;
import ar.edu.unlam.pb2.profugo.Profugo;

public class CazadorUrbano extends Cazador {
    public CazadorUrbano(String nombre, int experiencia) {
        super(nombre, experiencia);
    }

    @Override
    public boolean puedeCapturar(Profugo profugo, Entorno entorno) {
    	int expActual = this.getExperiencia();
    	
    	if(entorno == entorno.URBANO) {
    		expActual += 20;
    	}
    	this.intimidar(profugo);
        return expActual > profugo.getNivelInocencia() && profugo.isNervioso() != true ;
    }


}
