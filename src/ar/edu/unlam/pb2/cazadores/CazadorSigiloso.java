package ar.edu.unlam.pb2.cazadores;

import ar.edu.unlam.pb2.profugo.*;

public class CazadorSigiloso extends Cazador {
    
    public CazadorSigiloso(String nombre, int experienciaInicial) {
        super(nombre, experienciaInicial);
    }
    
    @Override
    protected Boolean capturaEspecifica(Profugo profugo) {
        return profugo.getNivelHabilidad() < 50;
    }
    
    @Override
    protected void intimidacionEspecifica(Profugo profugo) {
        profugo.reducirHabilidad(5);
    }
}
