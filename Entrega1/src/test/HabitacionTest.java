package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Habitacion;
import modelo.Precio;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HabitacionTest {

    private Habitacion habitacion;
    private Precio precios;

    @Before
    public void setUp() {
        int id = 1;
        int tipo = 0;
        int capacidadAdultos = 2;
        int capacidadNinios = 1;
        Boolean balcon = true;
        Boolean vista = false;
        Boolean cocina = true;
        int tamaño = 25;
        Boolean aire = true;
        Boolean calefaccion = true;
        int tamañoCama = 160;
        Boolean tv = true;
        Boolean cafetera = false;
        Boolean ropaCama = true;
        Boolean plancha = false;
        Boolean secador = true;
        Boolean voltaje = true;
        Boolean tomasA = true;
        Boolean tomasC = true;
        Boolean desayuno = true;

        Map<LocalDate, Integer> preciosEstandar = new HashMap<>();
        preciosEstandar.put(LocalDate.now(), 100);
        preciosEstandar.put(LocalDate.now().plusDays(1), 120);
        preciosEstandar.put(LocalDate.now().plusDays(2), 110);

        Map<LocalDate, Integer> preciosSuit = new HashMap<>();
        preciosSuit.put(LocalDate.now(), 150);
        preciosSuit.put(LocalDate.now().plusDays(1), 180);
        preciosSuit.put(LocalDate.now().plusDays(2), 170);

        Map<LocalDate, Integer> preciosSuitDoble = new HashMap<>();
        preciosSuitDoble.put(LocalDate.now(), 200);
        preciosSuitDoble.put(LocalDate.now().plusDays(1), 220);
        preciosSuitDoble.put(LocalDate.now().plusDays(2), 210);

        int precioAdulto = 50;
        int precioNinio = 25;
        int precioBalcon = 10;
        int precioVista = 0;
        int precioCocina = 15;

        precios = new Precio(preciosEstandar, preciosSuit, preciosSuitDoble, precioAdulto, precioNinio, precioBalcon, precioVista, precioCocina);

        habitacion = new Habitacion(id, tipo, capacidadAdultos, capacidadNinios, balcon, vista, cocina, tamaño, aire, calefaccion, tamañoCama, tv, cafetera, ropaCama, plancha, secador, voltaje, tomasA, tomasC, desayuno);
    }

    @Test
    public void testCalcularBaseporNoche() {
        LocalDate fecha = LocalDate.now();
        int precioBase = precios.getPreciosEstandar().get(fecha);
        int precioAdicionales = precios.getPrecioBalcon() + precios.getPrecioCocina();
        int precioCapacidad = precios.getPrecioAdulto() * habitacion.getCapacidadAdultos() + precios.getPrecioNinio() * habitacion.getCapacidadNinios();

        int precioEsperado = precioBase + precioAdicionales + precioCapacidad;
        int precioCalculado = habitacion.calcularBaseporNoche(precios, fecha);

        Assert.assertEquals(precioEsperado, precioCalculado);
    }

    @Test
    public void testGetCapacidadAdultos() {
        int capacidadAdultos = 2;
        Assert.assertEquals(capacidadAdultos, habitacion.getCapacidadAdultos());
    }

    @Test
    public void testGetCapacidadNinios() {
        int capacidadNinios = 1;
        Assert.assertEquals(capacidadNinios, habitacion.getCapacidadNinios());
    }

    @Test
    public void testSetReservada() {
        Boolean reservada = true;
        habitacion.setReservada(reservada);
        Assert.assertEquals(reservada, habitacion.getReservada());
    }

    @Test
    public void testGetId() {
        int id = 1;
        Assert.assertEquals(id, habitacion.getId());
    }

    @Test
    public void testGetTipo() {
        int tipo = 0;
        Assert.assertEquals(tipo, habitacion.getTipo());
    }

    @Test
    public void testGetBalcon() {
        Boolean balcon = true;
        Assert.assertEquals(balcon, habitacion.getBalcon());
    }

    @Test
    public void testGetVista() {
        Boolean vista = false;
        Assert.assertEquals(vista, habitacion.getVista());
    }

    @Test
    public void testGetCocina() {
        Boolean cocina = true;
        Assert.assertEquals(cocina, habitacion.getCocina());
    }

    @Test
    public void testGetTamaño() {
        int tamaño = 25;
        Assert.assertEquals(tamaño, habitacion.getTamaño());
    }

    @Test
    public void testGetAire() {
        Boolean aire = true;
        Assert.assertEquals(aire, habitacion.getAire());
    }

    @Test
    public void testGetCalefaccion() {
        Boolean calefaccion = true;
        Assert.assertEquals(calefaccion, habitacion.getCalefaccion());
    }

    @Test
    public void testGetTamañoCama() {
        int tamañoCama = 160;
        Assert.assertEquals(tamañoCama, habitacion.getTamañoCama());
    }

    @Test
    public void testGetTv() {
        Boolean tv = true;
        Assert.assertEquals(tv, habitacion.getTv());
    }

    @Test
    public void testGetCafetera() {
        Boolean cafetera = false;
        Assert.assertEquals(cafetera, habitacion.getCafetera());
    }

    @Test
    public void testGetRopaCama() {
        Boolean ropaCama = true;
        Assert.assertEquals(ropaCama, habitacion.getRopaCama());
    }

    @Test
    public void testGetPlancha() {
        Boolean plancha = false;
        Assert.assertEquals(plancha, habitacion.getPlancha());
    }

    @Test
    public void testGetSecador() {
        Boolean secador = true;
        Assert.assertEquals(secador, habitacion.getSecador());
    }

    @Test
    public void testGetVoltaje() {
        Boolean voltaje = true;
        Assert.assertEquals(voltaje, habitacion.getVoltaje());
    }

    @Test
    public void testGetTomasA() {
        Boolean tomasA = true;
        Assert.assertEquals(tomasA, habitacion.getTomasA());
    }

    @Test
    public void testGetTomasC() {
        Boolean tomasC = true;
        Assert.assertEquals(tomasC, habitacion.getTomasC());
    }

    @Test
    public void testGetDesayuno() {
        Boolean desayuno = true;
        Assert.assertEquals(desayuno, habitacion.getDesayuno());
    }
}
