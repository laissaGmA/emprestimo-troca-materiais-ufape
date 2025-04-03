package test;

import org.junit.Before;
import org.junit.Test;

import negocio.Apostila;
import negocio.EquipamentoEletronico;
import negocio.Livro;
import negocio.MaterialDeLaboratorio;

import static org.junit.Assert.*;

public class MaterialTest {
    private Livro livro;
    private Apostila apostila;
    private MaterialDeLaboratorio materialLab;
    private EquipamentoEletronico equipamento;

    @Before
    public void setUp() {
        livro = new Livro("Java Básico", "Livro de programação", "Autor X", "Programação");
        apostila = new Apostila("Algoritmos", "Apostila de estudo", "Computação");
        materialLab = new MaterialDeLaboratorio("Microscópio", "Usado para análises", true, "Biologia");
        equipamento = new EquipamentoEletronico("Notebook", "Dell XPS", "Dell", "XPS");
    }

    @Test
    public void testCriacaoMaterial() {
        assertEquals("Java Básico", livro.getNome());
        assertEquals("Apostila de estudo", apostila.getDescricao());
        assertEquals("Microscópio", materialLab.getNome());
        assertEquals("Dell", equipamento.getMarca());
    }

    @Test
    public void testDisponibilidadeInicial() {
        assertTrue(livro.isDisponivel());
        assertTrue(apostila.isDisponivel());
        assertTrue(materialLab.isDisponivel());
        assertTrue(equipamento.isDisponivel());
    }

    @Test
    public void testEmprestarMaterial() {
        livro.setDisponivel(false);
        assertFalse(livro.isDisponivel());

        equipamento.setDisponivel(false);
        assertFalse(equipamento.isDisponivel());
    }

    @Test
    public void testDevolverMaterial() {
        livro.setDisponivel(false);
        livro.setDisponivel(true);
        assertTrue(livro.isDisponivel());

        equipamento.setDisponivel(false);
        equipamento.setDisponivel(true);
        assertTrue(equipamento.isDisponivel());
    }

    @Test
    public void testToString() {
        String livroString = livro.toString();
        assertTrue(livroString.contains("Java Básico"));
        assertTrue(livroString.contains("Autor X"));

        String equipamentoString = equipamento.toString();
        assertTrue(equipamentoString.contains("Notebook"));
        assertTrue(equipamentoString.contains("Dell"));
    }
}
