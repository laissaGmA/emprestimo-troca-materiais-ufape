package negocio;

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

