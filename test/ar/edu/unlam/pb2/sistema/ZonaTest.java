package ar.edu.unlam.pb2.sistema;

import ar.edu.unlam.pb2.profugo.Profugo;
import ar.edu.unlam.pb2.sistema.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;

public class ZonaTest {
    private Zona zona;
    private Profugo profugo1;
    private Profugo profugo2;
    
    @Before
    public void setUp() {
        zona = new Zona("Test Zone");
        profugo1 = new Profugo(30, 40, false);
        profugo2 = new Profugo(25, 60, true);
    }
    
    @Test
    public void queSePuedaAgregarProfugo() {
        zona.agregarProfugo(profugo1);
        assertEquals(1, zona.getCantidadProfugos());
        assertTrue(zona.getProfugos().contains(profugo1));
    }
    
   @Test
    public void pruebaRemoverProfugo() {
        zona.agregarProfugo(profugo1);
        zona.agregarProfugo(profugo2);
        
        zona.removerProfugo(profugo1);
        
        assertEquals(1, zona.getCantidadProfugos());
        assertFalse(zona.getProfugos().contains(profugo1));
        assertTrue(zona.getProfugos().contains(profugo2));
    }
   
    @Test(expected = IllegalArgumentException.class)
    public void testAgregarProfugoNull() {
        zona.agregarProfugo(null);
    }
    
    @Test
    public void pruebaQueElHashSetPrevieneDuplicados() {
        zona.agregarProfugo(profugo1);
        zona.agregarProfugo(profugo1); 
        
        assertEquals(1, zona.getCantidadProfugos());
    }
}