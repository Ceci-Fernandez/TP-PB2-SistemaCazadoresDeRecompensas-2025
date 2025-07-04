package ar.edu.unlam.pb2.cazadores;

import ar.edu.unlam.pb2.profugo.Profugo;

public class CazadorRural extends Cazador {
    
    public CazadorRural(String nombre, Integer experienciaInicial) {
        super(nombre, experienciaInicial);
    }
    
    @Override
    protected Boolean capturaEspecifica(Profugo profugo) {
        return profugo.isNervioso();
    }
    
    @Override
    protected void intimidacionEspecifica(Profugo profugo) {
        profugo.setNervioso(true);
    }
}
