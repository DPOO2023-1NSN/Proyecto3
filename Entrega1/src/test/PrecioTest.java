package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Precio;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PrecioTest {

    private Precio precio;

    @Before
    public void setUp() {
        Map<LocalDate, Integer> preciosEstandar = createPreciosEstandar();
        Map<LocalDate, Integer> preciosSuit = createPreciosSuit();
        Map<LocalDate, Integer> preciosSuitDoble = createPreciosSuitDoble();
        int precioAdulto = 50;
        int precioNinio = 25;
        int precioBalcon = 10;
        int precioVista = 20;
        int precioCocina = 30;

        precio = new Precio(preciosEstandar, preciosSuit, preciosSuitDoble, precioAdulto, precioNinio, precioBalcon, precioVista, precioCocina);
    }

    @Test
    public void testGetPrecioAdulto() {
        int precioAdulto = 50;
        Assert.assertEquals(precioAdulto, precio.getPrecioAdulto());
    }

    @Test
    public void testGetPrecioNinio() {
        int precioNinio = 25;
        Assert.assertEquals(precioNinio, precio.getPrecioNinio());
    }

    @Test
    public void testGetPrecioBalcon() {
        int precioBalcon = 10;
        Assert.assertEquals(precioBalcon, precio.getPrecioBalcon());
    }

    @Test
    public void testGetPrecioVista() {
        int precioVista = 20;
        Assert.assertEquals(precioVista, precio.getPrecioVista());
    }

    @Test
    public void testGetPrecioCocina() {
        int precioCocina = 30;
        Assert.assertEquals(precioCocina, precio.getPrecioCocina());
    }

    @Test
    public void testGetPreciosEstandar() {
        Map<LocalDate, Integer> preciosEstandar = createPreciosEstandar();
        Assert.assertEquals(preciosEstandar, precio.getPreciosEstandar());
    }

    @Test
    public void testGetPreciosSuit() {
        Map<LocalDate, Integer> preciosSuit = createPreciosSuit();
        Assert.assertEquals(preciosSuit, precio.getPreciosSuit());
    }

    @Test
    public void testGetPreciosSuitDoble() {
        Map<LocalDate, Integer> preciosSuitDoble = createPreciosSuitDoble();
        Assert.assertEquals(preciosSuitDoble, precio.getPreciosSuitDoble());
    }

    private Map<LocalDate, Integer> createPreciosEstandar() {
        Map<LocalDate, Integer> preciosEstandar = new HashMap<>();
        preciosEstandar.put(LocalDate.of(2023, 1, 1), 100);
        preciosEstandar.put(LocalDate.of(2023, 1, 2), 120);
        return preciosEstandar;
    }

    private Map<LocalDate, Integer> createPreciosSuit() {
        Map<LocalDate, Integer> preciosSuit = new HashMap<>();
        preciosSuit.put(LocalDate.of(2023, 1, 1), 200);
        preciosSuit.put(LocalDate.of(2023, 1, 2), 240);
        return preciosSuit;
    }

    private Map<LocalDate, Integer> createPreciosSuitDoble() {
        Map<LocalDate, Integer> preciosSuitDoble = new HashMap<>();
        preciosSuitDoble.put(LocalDate.of(2023, 1, 1), 300);
        preciosSuitDoble.put(LocalDate.of(2023, 1, 2), 360);
        return preciosSuitDoble;
    }
}
