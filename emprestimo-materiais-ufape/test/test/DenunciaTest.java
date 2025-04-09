package test;

import negocio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DenunciaTest {
    private Usuario denunciante;
    private Usuario denunciado;
    private MaterialDeLaboratorio material;
    private Denuncia denuncia;

    @BeforeEach
    void setUp() {
        denunciante = new Usuario("Ana", "ana@teste.com", "222", "senha");
        denunciado = new Usuario("Pedro", "pedro@teste.com", "333", "senha123");
        material = new MaterialDeLaboratorio("Microscópio", "Equipamento óptico", true, "Lab Biologia");
        denuncia = new Denuncia(denunciante, denunciado, material, "Material danificado");
    }

    @Test
    void testCriacaoDenuncia() {
        assertEquals(denunciante, denuncia.getDenunciante());
        assertEquals(denunciado, denuncia.getDenunciado());
        assertEquals(material, denuncia.getMaterial());
        assertEquals("Material danificado", denuncia.getMotivo());
    }
}
