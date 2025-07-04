package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.cazadores.*;
import ar.edu.unlam.pb2.excepciones.CazadorException;
import ar.edu.unlam.pb2.sistema.Agencia;
import ar.edu.unlam.pb2.sistema.Zona;
import ar.edu.unlam.pb2.profugo.Profugo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AgenciaTest {
    private Agencia agencia;
    private CazadorUrbano cazadorUrbano;
    private CazadorRural cazadorRural;
    private CazadorSigiloso cazadorSigiloso;
    private Zona zona;
    
    @Before
    public void setUp() {
        agencia = new Agencia();
        cazadorUrbano = new CazadorUrbano("Carlos", 50);
        cazadorRural = new CazadorRural("Miguel", 75);
        cazadorSigiloso = new CazadorSigiloso("Ana", 55);
        zona = new Zona("Centro");
        
        agencia.registrarCazador(cazadorUrbano);
        agencia.registrarCazador(cazadorRural);
        agencia.registrarCazador(cazadorSigiloso);
        agencia.registrarZona(zona);
    }
    
    @Test
    public void queSePuedaRegistrarCazadorYZona() {
        assertEquals(3, agencia.getCazadores().size());
        assertEquals(1, agencia.getZonas().size());
        assertEquals(cazadorUrbano, agencia.getCazador("Carlos"));
    }
    
    @Test(expected = CazadorException.class)
    public void queNoSePuedaRegistrarCazadorDuplicado() {
        CazadorUrbano cazadorDuplicado = new CazadorUrbano("Carlos", 30);
        agencia.registrarCazador(cazadorDuplicado);
    }
    
    @Test
    public void queCazadorUrbanoCaptureProfugoCalmo() {
        Profugo profugoCalmo = new Profugo(30, 40, false);
        zona.agregarProfugo(profugoCalmo);
        
        agencia.enviarCazadorAZona("Carlos", "Centro");
        
        assertEquals(1, cazadorUrbano.getCantidadCapturas());
        assertEquals(0, zona.getCantidadProfugos());
    }
    
    @Test
    public void queCazadorRuralCaptureProfugoNervioso() {
        Profugo profugoNervioso = new Profugo(35, 50, true);
        zona.agregarProfugo(profugoNervioso);
        
        agencia.enviarCazadorAZona("Miguel", "Centro");
        
        assertEquals(1, cazadorRural.getCantidadCapturas());
        assertEquals(0, zona.getCantidadProfugos());
    }
    
    @Test
    public void queCazadorSigilosoCaptureProfugoBajaHabilidad() {
        Profugo profugoBajaHabilidad = new Profugo(40, 30, false);
        zona.agregarProfugo(profugoBajaHabilidad);
        
        agencia.enviarCazadorAZona("Ana", "Centro");
        
        assertEquals(1, cazadorSigiloso.getCantidadCapturas());
        assertEquals(0, zona.getCantidadProfugos());
    }
    
    @Test
    public void queSeIntimideCuandoNoPuedeCapturar() {
        Profugo profugoInocente = new Profugo(80, 40, false);
        zona.agregarProfugo(profugoInocente);
        
        agencia.enviarCazadorAZona("Carlos", "Centro");
        
        assertEquals(0, cazadorUrbano.getCantidadCapturas());
        assertEquals(78, profugoInocente.getNivelInocencia(),0.1); // 80 - 2
        assertEquals(1, zona.getCantidadProfugos());
    }
    
    @Test
    public void queSePuedaObtenerProfugoMasHabil() {
        Profugo profugo1 = new Profugo(30, 40, false);
        Profugo profugo2 = new Profugo(25, 80, false);
        
        zona.agregarProfugo(profugo1);
        zona.agregarProfugo(profugo2);
        
        agencia.enviarCazadorAZona("Carlos", "Centro");
        
        Profugo masHabil = agencia.obtenerProfugoMasHabilCapturado();
        assertEquals(80, masHabil.getNivelHabilidad(),0.01);
    }
    
    @Test
    public void queSePuedaObtenerCazadorConMasCapturas() {
        
        Profugo profugoNervioso1 = new Profugo(60, 30, true);
        Profugo profugoNervioso2 = new Profugo(65, 45, true);
        Profugo profugoNervioso3 = new Profugo(70, 35, true);
        
        zona.agregarProfugo(profugoNervioso1);
        zona.agregarProfugo(profugoNervioso2);
        zona.agregarProfugo(profugoNervioso3);
        
        agencia.enviarCazadorAZona("Miguel", "Centro");
        
        Cazador mejorCazador = agencia.obtenerCazadorConMasCapturas();
        assertEquals("Miguel", mejorCazador.getNombre());
        assertEquals(3, mejorCazador.getCantidadCapturas());
    }
    
    @Test
    public void queSePuedanObtenerEstadisticasBasicas() {
        Profugo profugo = new Profugo(30, 40, false);
        zona.agregarProfugo(profugo);
        
        agencia.enviarCazadorAZona("Carlos", "Centro");
        
        assertEquals(3, agencia.getTotalCazadores(),0.01);
        assertEquals(1, agencia.getTotalZonas());
        assertEquals(1, agencia.getTotalCapturas());
        assertEquals(0, agencia.getProfugosRestantesEnTodasLasZonas());
    }
    
    @Test
    public void queSePuedanObtenerEstadisticasConProfugosRestantes() {
        Profugo profugoCapturado = new Profugo(30, 40, false);
        Profugo profugoIntimidado = new Profugo(80, 50, false);
        
        zona.agregarProfugo(profugoCapturado);
        zona.agregarProfugo(profugoIntimidado);
        
        agencia.enviarCazadorAZona("Carlos", "Centro");
        
        assertEquals(1, agencia.getTotalCapturas());
        assertEquals(1, agencia.getProfugosRestantesEnTodasLasZonas());
    }
    
    @Test
    public void queSePuedaObtenerTodosLosProfugosCapturados() {
        Profugo profugo1 = new Profugo(30, 40, false);
        Profugo profugo2 = new Profugo(25, 50, false);
        
        zona.agregarProfugo(profugo1);
        zona.agregarProfugo(profugo2);
        
        agencia.enviarCazadorAZona("Carlos", "Centro");
        
        assertEquals(2, agencia.obtenerTodosLosProfugosCapturados().size());
        assertTrue(agencia.obtenerTodosLosProfugosCapturados().contains(profugo1));
        assertTrue(agencia.obtenerTodosLosProfugosCapturados().contains(profugo2));
    }
    
    @Test
    public void queRetorneNullSiNoHayProfugosCapturados() {
        Profugo masHabil = agencia.obtenerProfugoMasHabilCapturado();
        assertNull(masHabil);
    }
    
    @Test(expected = CazadorException.class)  
    public void queNoSePuedaEnviarCazadorInexistente() {
        agencia.enviarCazadorAZona("NoExiste", "Centro");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void queNoSePuedaEnviarCazadorAZonaInexistente() {
        agencia.enviarCazadorAZona("Carlos", "ZonaInexistente");
    }
    @Test
    public void queSePuedaRealizarOperacionCompleta() {
        Zona bosque = new Zona("Bosque");
        Zona suburbio = new Zona("Suburbio");
        agencia.registrarZona(bosque);
        agencia.registrarZona(suburbio);
        
        
        Profugo profugoCalmo = new Profugo(30, 40, false);       
        Profugo profugoNervioso = new Profugo(60, 30, true);      
        Profugo profugoBajaHabilidad = new Profugo(40, 25, false);
        
        zona.agregarProfugo(profugoCalmo);          
        bosque.agregarProfugo(profugoNervioso);     
        suburbio.agregarProfugo(profugoBajaHabilidad); 
        
        
        agencia.enviarCazadorAZona("Carlos", "Centro");   
        agencia.enviarCazadorAZona("Miguel", "Bosque");    
        agencia.enviarCazadorAZona("Ana", "Suburbio");     
        
       
        assertEquals(3, agencia.getTotalCapturas());
        assertEquals(0, agencia.getProfugosRestantesEnTodasLasZonas());
        
        Cazador mejorCazador = agencia.obtenerCazadorConMasCapturas();
        assertNotNull(mejorCazador);
        assertEquals(1, mejorCazador.getCantidadCapturas());
    }
}
