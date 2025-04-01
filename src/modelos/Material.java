package modelos;

public abstract class Material {
	private static int contadorId = 0;
	private int id;
	private String nome;
	private CondicaoMaterial condicao;
	private boolean disponivel;
	
	public Material() {
		
	}

	public Material(String nome, CondicaoMaterial condicao) {
		this.id = contadorId++;
		this.nome = nome;
		this.condicao = condicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CondicaoMaterial getCondicao() {
		return condicao;
	}

	public void setCondicao(CondicaoMaterial condicao) {
		this.condicao = condicao;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public int getId() {
		return id;
	}
	
	public abstract String descricao();
	

}
