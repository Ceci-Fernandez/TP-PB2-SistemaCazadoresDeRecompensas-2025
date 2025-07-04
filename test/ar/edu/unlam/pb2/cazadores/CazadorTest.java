package ar.edu.unlam.pb2.cazadores;

import ar.edu.unlam.pb2.profugo.*;
import ar.edu.unlam.pb2.sistema.Zona;
import ar.edu.unlam.pb2.cazadores.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CazadorTest {
    private Zona zona;
    private Profugo profugoNervioso;
    private Profugo profugoCalmo;
    private CazadorUrbano cazadorUrbano;
    private CazadorRural cazadorRural;
    private CazadorSigiloso cazadorSigiloso;
    
    @Before
    public void setUp() {
        zona = new Zona("Centro");
        profugoNervioso = new Profugo(30, 40, true);
        profugoCalmo = new Profugo(25, 60, false);
        
        cazadorUrbano = new CazadorUrbano("Juan", 50);
        cazadorRural = new CazadorRural("Pedro", 50);
        cazadorSigiloso = new CazadorSigiloso("Ana", 50);
        
        zona.agregarProfugo(profugoNervioso);
        zona.agregarProfugo(profugoCalmo);
    }
    
    @Test
    public void queSePuedaCapturarProfugoCalmoConCazadorUrbano() {
        cazadorUrbano.realizarCaptura(zona);
        assertEquals(1, cazadorUrbano.getCantidadCapturas());
        assertTrue(cazadorUrbano.getProfugosCapturados().contains(profugoCalmo));
    }
    
    @Test
    public void queSePuedaCapturarProfugoNerviosoConCazadorRural() {
        cazadorRural.realizarCaptura(zona);
        assertEquals(1, cazadorRural.getCantidadCapturas());
        assertTrue(cazadorRural.getProfugosCapturados().contains(profugoNervioso));
    }
    
    @Test
    public void queSePuedaCapturarProfugoBajaHabilidadConCazadorSigiloso() {
        Profugo profugoBajaHabilidad = new Profugo(20, 30, false);
        zona.agregarProfugo(profugoBajaHabilidad);
        
        cazadorSigiloso.realizarCaptura(zona);
        assertTrue(cazadorSigiloso.getProfugosCapturados().contains(profugoBajaHabilidad));
    }
    
    @Test
    public void queSeReduzcanDosDeInocenciaAlIntimidar() {
        int inocenciaInicial = profugoNervioso.getNivelInocencia();
        cazadorUrbano.realizarCaptura(zona);
        assertEquals(inocenciaInicial - 2, profugoNervioso.getNivelInocencia(),0.01);
    }
    
    @Test
    public void queSePuedaDuplicarHabilidadConArtesMarciales() {
        Profugo profugoConArtes = new ArtesMarciales(new Profugo(30, 40, false));
        assertEquals(80, profugoConArtes.getNivelHabilidad(),0.01);
    }
    
    @Test
    public void queArtesMarcialesNoSupereLimiteMaximo() {
        Profugo profugoConArtes = new ArtesMarciales(new Profugo(30, 60, false));
        assertEquals(100, profugoConArtes.getNivelHabilidad(),0.01);
    }
    
    @Test
    public void queSePuedaMantenerInocenciaMinimaConProteccionLegal() {
        Profugo profugoConProteccion = new ProteccionLegal(new Profugo(30, 40, false));
        profugoConProteccion.reducirInocencia(50);
        assertEquals(40, profugoConProteccion.getNivelInocencia(),0.01);
    }
    
    @Test
    public void queSePuedaEvitarNerviosismoConEntrenamientoElite() {
        Profugo profugoElite = new EntrenamientoElite(new Profugo(30, 40, true));
        assertFalse(profugoElite.isNervioso());
        profugoElite.setNervioso(true);
        assertFalse(profugoElite.isNervioso());
    }
    
   
   
    @Test
    public void queSeCalculeExperienciaCorrectamente() {
   
        Zona zonaLimpia = new Zona("TestZona");
        
        Profugo profugo1 = new Profugo(20, 30, false);
        Profugo profugo2 = new Profugo(60, 40, true);
        
        zonaLimpia.agregarProfugo(profugo1);
        zonaLimpia.agregarProfugo(profugo2);
        
        int experienciaInicial = cazadorUrbano.getExperiencia();
        cazadorUrbano.realizarCaptura(zonaLimpia);
        
        assertEquals(experienciaInicial + 42, cazadorUrbano.getExperiencia());
    }
}