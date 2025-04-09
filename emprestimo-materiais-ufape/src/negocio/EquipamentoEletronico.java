package negocio;

/**
 * Representa um equipamento eletrônico (como fone, mouse, etc.) disponível para empréstimo.
 * Herda os atributos de Material e adiciona a marca do equipamento.
 * 
 * @author Laissa Maria Gama Silva
 */


public class EquipamentoEletronico extends Material {
    private String marca;
    private String modelo;

    public EquipamentoEletronico(String nome, String descricao, String marca, String modelo) {
        super(nome, descricao, true);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Equipamento Eletrônico: " + nome + " - " + descricao + " (Marca: " + marca + ", Modelo: " + modelo + ", Disponível: " + disponivel + ")";
    }
}

