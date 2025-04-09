package test;

import negocio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvaliacaoTest {
    private Usuario usuario;
    private Livro livro;
    private Avaliacao avaliacao;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Carlos", "carlos@teste.com", "111", "senha");
        livro = new Livro("Java Avançado", "Livro técnico", "Autor X", "Programação");
        avaliacao = new Avaliacao(usuario, livro, 4, "Muito bom!");
    }

    @Test
    void testCriacaoAvaliacao() {
        assertEquals(usuario, avaliacao.getAvaliador());
        assertEquals(livro, avaliacao.getMaterial());
        assertEquals(4, avaliacao.getNota());
        assertEquals("Muito bom!", avaliacao.getComentario());
    }
}
