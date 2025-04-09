package test;


import org.junit.Before;
import org.junit.Test;

import negocio.Livro;
import negocio.SistemaEmprestimo;
import negocio.Usuario;

import static org.junit.Assert.*;

public class SistemaEmprestimoTest {
    private SistemaEmprestimo sistema;
    private Usuario usuario;
    private Livro livro;

    @Before
    public void setUp() {
        sistema = new SistemaEmprestimo();
        usuario = new Usuario("João", "joao@email.com", "12345", "senha123");
        livro = new Livro("Java Básico", "Livro de programação", "Autor X", "Programação");

        sistema.registrarUsuario(usuario);
        sistema.adicionarMaterial(livro);
    }

    @Test
    public void testEmprestarMaterialComSucesso() {
        boolean resultado = sistema.emprestarMaterial("12345", "Java Básico");
        assertTrue(resultado);
        assertFalse(livro.isDisponivel());
        assertTrue(usuario.getMateriaisEmprestados().contains(livro));
    }

    @Test
    public void testEmprestarMaterialJaEmprestado() {
        sistema.emprestarMaterial("12345", "Java Básico");
        boolean resultado = sistema.emprestarMaterial("12345", "Java Básico");
        assertFalse(resultado);
    }

    @Test
    public void testEmprestarMaterialInexistente() {
        boolean resultado = sistema.emprestarMaterial("12345", "Livro Inexistente");
        assertFalse(resultado);
    }

    @Test
    public void testEmprestarMaterialParaUsuarioInexistente() {
        boolean resultado = sistema.emprestarMaterial("99999", "Java Básico");
        assertFalse(resultado);
    }

    @Test
    public void testDevolverMaterialComSucesso() {
        sistema.emprestarMaterial("12345", "Java Básico");
        boolean resultado = sistema.devolverMaterial("12345", "Java Básico");
        assertTrue(resultado);
        assertTrue(livro.isDisponivel());
        assertFalse(usuario.getMateriaisEmprestados().contains(livro));
    }

    @Test
    public void testDevolverMaterialNaoEmprestado() {
        boolean resultado = sistema.devolverMaterial("12345", "Java Básico");
        assertFalse(resultado);
    }

    @Test
    public void testAumentarRankingUsuario() {
        sistema.aumentarRankingUsuario("12345");
        assertEquals(1, usuario.getRanking());
    }

    @Test
    public void testDiminuirRankingUsuario() {
        sistema.aumentarRankingUsuario("12345");
        sistema.diminuirRankingUsuario("12345");
        assertEquals(0, usuario.getRanking());
    }
}
