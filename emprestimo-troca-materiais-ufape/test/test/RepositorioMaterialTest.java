package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dados.RepositorioMaterial;
import negocio.Livro;
import negocio.Material;

class RepositorioMaterialTest {
    private RepositorioMaterial repositorio;
    
    @BeforeEach
    void setUp() {
        repositorio = new RepositorioMaterial();
    }
    
    @Test
    void testAdicionarEMBuscarMaterial() {
        Material livro = new Livro("Java POO", "Livro sobre POO em Java", "Autor Desconhecido", "Programação");
        repositorio.adicionar(livro);
        
        Material resultado = repositorio.buscar("Java POO");
        assertNotNull(resultado);
        assertEquals("Java POO", resultado.getNome());
    }
    
    @Test
    void testRemoverMaterial() {
        Material livro = new Livro("Design Patterns", "Livro sobre padrões de projeto", "GoF", "Software");
        repositorio.adicionar(livro);
        assertTrue(repositorio.remover("Design Patterns"));
        assertNull(repositorio.buscar("Design Patterns"));
    }
    
    @Test
    void testListarTodos() {
        repositorio.adicionar(new Livro("Clean Code", "Livro sobre boas práticas", "Robert C. Martin", "Engenharia de Software"));
        repositorio.adicionar(new Livro("Refactoring", "Melhoria de código", "Martin Fowler", "Desenvolvimento"));
        
        assertEquals(2, repositorio.listarTodos().size());
    }
}