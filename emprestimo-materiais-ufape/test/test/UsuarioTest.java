package test;

import negocio.Livro;
import negocio.Usuario;
import negocio.Material;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("João", "joao@email.com", "12345", "senha123");
    }

    @Test
    void testAumentarRanking() {
        int rankingInicial = usuario.getRanking();
        usuario.aumentarRanking();
        assertEquals(rankingInicial + 1, usuario.getRanking());
    }

    @Test
    void testDiminuirRanking() {
        usuario.aumentarRanking(); 
        int rankingInicial = usuario.getRanking();
        usuario.diminuirRanking();
        assertEquals(Math.max(0, rankingInicial - 1), usuario.getRanking());
    }
    
    @Test
    void testEmprestarMaterial() {
        Material livro = new Livro("Design Patterns", "Livro sobre padrões de projeto", "GoF", "Software");
        assertTrue(usuario.emprestarMaterial(livro));
        assertTrue(usuario.getMateriaisEmprestados().contains(livro));
    }

    @Test
    void testDevolverMaterial() {
        Material livro = new Livro("Design Patterns", "Livro sobre padrões de projeto", "GoF", "Software");
        usuario.emprestarMaterial(livro);
        assertTrue(usuario.devolverMaterial(livro));
        assertFalse(usuario.getMateriaisEmprestados().contains(livro));
    }
}


