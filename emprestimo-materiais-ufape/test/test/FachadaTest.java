package test;

import fachada.Fachada;
import negocio.*;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FachadaTest {

    @BeforeEach
    public void setUp() {
        Fachada.inicializarSistema(); // Carrega dados de exemplo
    }

    @Test
    public void testFluxoCompletoDoSistema() {
        // Adiciona novo usuário e material
        Usuario novoUsuario = new Usuario("Laissa", "laissa@ufape.edu.br", "999", "1234");
        Fachada.registrarUsuario(novoUsuario);

        Livro livro = new Livro("Estruturas de Dados", "Livro sobre listas, pilhas e filas", "Nível técnico", "Computação");
        Fachada.adicionarMaterial(livro);

        // Confere se foram adicionados
        Usuario u = Fachada.buscarUsuario("999");
        Material m = Fachada.buscarMaterial("Estruturas de Dados");

        assertNotNull(u);
        assertEquals("Laissa", u.getNome());

        assertNotNull(m);
        assertEquals("Estruturas de Dados", m.getNome());

        // Empréstimo
        boolean emprestado = Fachada.emprestarMaterial("999", "Estruturas de Dados");
        assertTrue(emprestado);
        assertFalse(m.isDisponivel());

        // Devolução
        boolean devolvido = Fachada.devolverMaterial("999", "Estruturas de Dados");
        assertTrue(devolvido);
        assertTrue(m.isDisponivel());

        // Avaliação
        Fachada.avaliarMaterial("999", "Estruturas de Dados", 4, "Conteúdo muito bom!");
        List<Avaliacao> avaliacoes = Fachada.listarAvaliacoesDeMaterial("Estruturas de Dados");

        assertEquals(1, avaliacoes.size());
        assertEquals("Conteúdo muito bom!", avaliacoes.get(0).getComentario());

        // Denúncia (usando outro usuário de exemplo já inicializado: João = 123)
        Fachada.denunciarMaterial("999", "123", "Estruturas de Dados", "Não devolveu no prazo.");
        List<Denuncia> denuncias = Fachada.listarDenunciasContraUsuario("123");

        assertEquals(1, denuncias.size());
        assertEquals("Não devolveu no prazo.", denuncias.get(0).getMotivo());
;
    }
}

