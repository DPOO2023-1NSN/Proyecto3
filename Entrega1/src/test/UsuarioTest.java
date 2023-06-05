package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Usuario;

public class UsuarioTest {
    private Usuario usuario;

    @Before
    public void setUp() {
        usuario = new Usuario("sergio", "password123", "Sergio", "123456789");
    }

    @Test
    public void testGetNombreUsuario() {
        String nombreUsuario = usuario.getNombreUsuario();
        Assert.assertEquals("sergio", nombreUsuario);
    }

    @Test
    public void testGetContraseña() {
        String contraseña = usuario.getContraseña();
        Assert.assertEquals("password123", contraseña);
    }

    @Test
    public void testGetNombre() {
        String nombre = usuario.getNombre();
        Assert.assertEquals("Sergio", nombre);
    }

    @Test
    public void testGetDocumento() {
        String documento = usuario.getDocumento();
        Assert.assertEquals("123456789", documento);
    }

}

