package test;

import dados.RepositorioUsuario;
import negocio.Usuario;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RepositorioUsuarioTest {
    private RepositorioUsuario repositorio;
    private Usuario usuario1;
    private Usuario usuario2;

    @Before
    public void setUp() {
        repositorio = new RepositorioUsuario();
        usuario1 = new Usuario("João", "joao@email.com", "12345", "senha123");
        usuario2 = new Usuario("Maria", "maria@email.com", "67890", "senha456");

        repositorio.adicionar(usuario1);
        repositorio.adicionar(usuario2);
    }

    @Test
    public void testAdicionarUsuario() {
        Usuario usuario3 = new Usuario("Pedro", "pedro@email.com", "11223", "senha789");
        repositorio.adicionar(usuario3);
        assertEquals(usuario3, repositorio.buscar("11223"));
    }

    @Test
    public void testBuscarUsuarioExistente() {
        assertEquals(usuario1, repositorio.buscar("12345"));
        assertEquals(usuario2, repositorio.buscar("67890"));
    }

    @Test
    public void testBuscarUsuarioInexistente() {
        assertNull(repositorio.buscar("99999"));
    }

    @Test
    public void testRemoverUsuario() {
        repositorio.remover("12345");
        assertNull(repositorio.buscar("12345"));
    }
}
