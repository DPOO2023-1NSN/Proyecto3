package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Servicio;

public class ServicioTest {

    private Servicio servicio;

    @Before
    public void setUp() {
        int id = 1;
        String nombre = "Servicio de limpieza";
        int precio = 50;

        servicio = new Servicio(id, nombre, precio);
    }

    @Test
    public void testGetId() {
        int id = 1;
        Assert.assertEquals(id, servicio.getId());
    }

    @Test
    public void testGetPrecio() {
        int precio = 50;
        Assert.assertEquals(precio, servicio.getPrecio());
    }

    @Test
    public void testSetPrecio() {
        int nuevoPrecio = 60;
        servicio.setPrecio(nuevoPrecio);
        Assert.assertEquals(nuevoPrecio, servicio.getPrecio());
    }

    @Test
    public void testGetPagado() {
        Boolean pagado = false;
        Assert.assertEquals(pagado, servicio.getPagado());
    }

    @Test
    public void testSetPagado() {
        Boolean nuevoEstado = true;
        servicio.setPagado(nuevoEstado);
        Assert.assertEquals(nuevoEstado, servicio.getPagado());
    }

    @Test
    public void testGetNombre() {
        String nombre = "Servicio de limpieza";
        Assert.assertEquals(nombre, servicio.getNombre());
    }
}

