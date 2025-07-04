package ar.edu.unlam.pb2.cazadores;

import java.util.*;

import ar.edu.unlam.pb2.excepciones.ProfugoException;
import ar.edu.unlam.pb2.profugo.Profugo;
import ar.edu.unlam.pb2.sistema.Zona;


public abstract class Cazador {
    protected String nombre;
    protected Integer experiencia;
    protected List<Profugo> profugosCapturados;
    

    public Cazador(String nombre, Integer experienciaInicial) {
        this.nombre = nombre;
        this.experiencia = experienciaInicial;
        this.profugosCapturados = new ArrayList<>();
    }
    
    public void realizarCaptura(Zona zona) throws ProfugoException{
        List<Profugo> profugosIntimidados = new ArrayList<>();
        Set<Profugo> profugosARemover = new HashSet<>();
        
        int capturasAntes = profugosCapturados.size();      
        
        if(zona == null) {
        	throw new ProfugoException ("Zona invalida");
        }
       
        for (Profugo profugo : zona.getProfugos()) {
            if (puedeCapturar(profugo)) {
                capturarProfugo(profugo);
                profugosARemover.add(profugo);
            } else {
                intimidarProfugo(profugo);
                profugosIntimidados.add(profugo);
            }
        }
        
        zona.removerProfugos(profugosARemover);
        

        int nuevasCapturas = profugosCapturados.size() - capturasAntes;
        sumarExperiencia(profugosIntimidados, nuevasCapturas);
    }
    
    private Boolean puedeCapturar(Profugo profugo) {
        Boolean condicionGeneral = this.experiencia > profugo.getNivelInocencia();
        Boolean condicionEspecifica = capturaEspecifica(profugo);
        return condicionGeneral && condicionEspecifica;
    }
    
    protected abstract Boolean capturaEspecifica(Profugo profugo);
    
    protected abstract void intimidacionEspecifica(Profugo profugo);
    
    private void capturarProfugo(Profugo profugo) {
        profugosCapturados.add(profugo);
    }

    private void intimidarProfugo(Profugo profugo) {
        profugo.reducirInocencia(2); 
        intimidacionEspecifica(profugo); 
    }
    
    private void sumarExperiencia(List<Profugo> intimidados, int nuevasCapturasEnEsteRound) {
        int minimoHabilidadIntimidados = 0;
        
        if (!intimidados.isEmpty()) {
            minimoHabilidadIntimidados = intimidados.get(0).getNivelHabilidad();
            for (Profugo profugo : intimidados) {
                if (profugo.getNivelHabilidad() < minimoHabilidadIntimidados) {
                    minimoHabilidadIntimidados = profugo.getNivelHabilidad();
                }
            }
        }
        
        int experienciaGanada = minimoHabilidadIntimidados + (2 * nuevasCapturasEnEsteRound);
        this.experiencia += experienciaGanada;
    }
 
    public String getNombre() { return nombre; }
    public int getExperiencia() { return experiencia; }
    public List<Profugo> getProfugosCapturados() { return new ArrayList<>(profugosCapturados); }
    public int getCantidadCapturas() { return profugosCapturados.size(); }
    
    @Override
    public String toString() {
        return String.format("%s[Experiencia: %d, Capturas: %d]", 
                           getClass().getSimpleName(), experiencia, profugosCapturados.size());
    }
}