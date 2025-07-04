package ar.edu.unlam.pb2.sistema;

import java.util.*;

import ar.edu.unlam.pb2.profugo.Profugo;

public class Zona {
    private String nombre;
    private Set<Profugo> profugos; // Usa HashSet para evitar duplicados y mejorar rendimiento
    
    public Zona(String nombre) {
        this.nombre = nombre;
        this.profugos = new HashSet<>();
    }
    
    public void agregarProfugo(Profugo profugo) {
        if (profugo == null) {
            throw new IllegalArgumentException("El prófugo no puede ser null");
        }
        profugos.add(profugo);
    }
    
    public void removerProfugos(Set<Profugo> profugosARemover) {
        profugos.removeAll(profugosARemover);
    }
    
    public void removerProfugo(Profugo profugo) {
        profugos.remove(profugo);
    }
    
    public Set<Profugo> getProfugos() {
        return new HashSet<>(profugos);
    }
    
    public String getNombre() { return nombre; }
    public int getCantidadProfugos() { return profugos.size(); }
    public boolean estaVacia() { return profugos.isEmpty(); }
    
    @Override
    public String toString() {
        return String.format("Zona[%s - %d prófugos]", nombre, profugos.size());
    }
}