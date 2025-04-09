package repositorio;

import dados.RepositorioDenuncia;
import negocio.Denuncia;
import negocio.Livro;
import negocio.Material;
import negocio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepositorioDenunciaTest {

    private RepositorioDenuncia repositorio;
    private Usuario denunciante;
    private Usuario denunciado;
    private Material livro1;
    private Material livro2;

    @BeforeEach
    public void setUp() {
        repositorio = new RepositorioDenuncia();
        denunciante = new Usuario("Denunciante", "denunciante@email.com", "111", "senha1");
        denunciado = new Usuario("Denunciado", "denunciado@email.com", "222", "senha2");
        livro1 = new Livro("Livro X", "Descrição X", "Autor X", "Categoria X");
        livro2 = new Livro("Livro Y", "Descrição Y", "Autor Y", "Categoria Y");
    }

    @Test
    public void testAdicionarDenuncia() {
        Denuncia denuncia = new Denuncia(denunciante, denunciado, livro1, "Material danificado");
        repositorio.adicionarDenuncia(denuncia);

        List<Denuncia> todas = repositorio.listarTodasDenuncias();
        assertEquals(1, todas.size());
        assertEquals(denuncia, todas.get(0));
    }

    @Test
    public void testListarDenunciasPorMaterial() {
        Denuncia d1 = new Denuncia(denunciante, denunciado, livro1, "Problema 1");
        Denuncia d2 = new Denuncia(denunciante, denunciado, livro2, "Problema 2");
        Denuncia d3 = new Denuncia(denunciante, denunciado, livro1, "Problema 3");

        repositorio.adicionarDenuncia(d1);
        repositorio.adicionarDenuncia(d2);
        repositorio.adicionarDenuncia(d3);

        List<Denuncia> denunciasLivro1 = repositorio.listarDenunciasPorMaterial(livro1);
        assertEquals(2, denunciasLivro1.size());
        assertTrue(denunciasLivro1.contains(d1));
        assertTrue(denunciasLivro1.contains(d3));
    }

    @Test
    public void testListarDenunciasContraUsuario() {
        Usuario outroDenunciado = new Usuario("Outro", "outro@email.com", "333", "senha3");

        Denuncia d1 = new Denuncia(denunciante, denunciado, livro1, "Atraso");
        Denuncia d2 = new Denuncia(denunciante, outroDenunciado, livro2, "Livro danificado");

        repositorio.adicionarDenuncia(d1);
        repositorio.adicionarDenuncia(d2);

        List<Denuncia> contraDenunciado = repositorio.listarDenunciasContraUsuario(denunciado);
        assertEquals(1, contraDenunciado.size());
        assertTrue(contraDenunciado.contains(d1));
    }

    @Test
    public void testListarTodasDenuncias() {
        repositorio.adicionarDenuncia(new Denuncia(denunciante, denunciado, livro1, "Descaso"));
        repositorio.adicionarDenuncia(new Denuncia(denunciante, denunciado, livro2, "Agressivo"));

        List<Denuncia> todas = repositorio.listarTodasDenuncias();
        assertEquals(2, todas.size());
    }
}
