package ar.edu.unlam.pb2.cazadores;

import ar.edu.unlam.pb2.tipos.Entorno;

public class CazadorRural extends Cazador {
    public CazadorRural(String nombre, int experiencia) {
        super(nombre, experiencia);
    }

    @Override
    public boolean puedeCapturar(Profugo profugo, Entorno entorno) {
    	int expActual = this.getExperiencia();
    	
    	if(entorno == entorno.RURAL) {
    		expActual += 20;
    	}
    	this.intimidar(profugo);
        return expActual > profugo.getNivelInocencia() && profugo.isNervioso() == true ;
    }
}
