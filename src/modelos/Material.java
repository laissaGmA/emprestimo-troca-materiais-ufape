package modelos;

public class Material {
	private static int contadorId = 0;
	private int id;
	private String nome;
	private String descricao;
	private CondicaoMaterial condicao;
	private boolean disponivel;
	
	public Material() {
		
	}

	public Material(String nome, String descricao, CondicaoMaterial condicao) {
		this.id = contadorId++;
		this.nome = nome;
		this.descricao = descricao;
		this.condicao = condicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	


	
	

}
