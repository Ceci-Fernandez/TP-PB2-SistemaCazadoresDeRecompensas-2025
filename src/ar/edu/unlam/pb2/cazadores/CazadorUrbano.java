package ar.edu.unlam.pb2.cazadores;

import ar.edu.unlam.pb2.profugo.Profugo;

public class CazadorUrbano extends Cazador {
    
    public CazadorUrbano(String nombre, Integer experienciaInicial) {
        super(nombre, experienciaInicial);
    }
    
    @Override
    protected Boolean capturaEspecifica(Profugo profugo) {
        return !profugo.isNervioso();
    }
    
    @Override
    protected void intimidacionEspecifica(Profugo profugo) {
        profugo.setNervioso(false);
    }
}