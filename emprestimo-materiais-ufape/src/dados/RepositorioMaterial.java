package dados;

import negocio.Material;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMaterial {
    private List<Material> materiais;

    public RepositorioMaterial() {
        this.materiais = new ArrayList<>();
    }

    public void adicionar(Material material) {
        materiais.add(material);
    }
    
    public boolean remover(String nome) {
        return materiais.removeIf(material -> material.getNome().equals(nome));
    }



    public List<Material> listar() {
        return new ArrayList<>(materiais);
    }

    
    public List<Material> listarTodos() {
        return new ArrayList<>(materiais);
    }

    public Material buscar(String nome) {
        for (Material material : materiais) {
            if (material.getNome().equalsIgnoreCase(nome)) {
                return material;
            }
        }
        return null; 
    }
}


