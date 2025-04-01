package modelos;

public class MaterialLeitura extends Material{

	private String assunto;
	private String autor;
	private int numeroPaginas;
	private String idioma;
	
	public MaterialLeitura() {
		super();
	}

	public MaterialLeitura(String nome, CondicaoMaterial condicao, String assunto, String autor, int numeroPaginas,
			String idioma) {
		super(nome, condicao);
		this.assunto = assunto;
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
		this.idioma = idioma;
	}	

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public String descricao() {
		return "Material de Leitura: " + getNome() + "\n" +
	           "Autor: " + autor + "\n" +
	           "Assunto: " + assunto + "\n" +
	           "Páginas: " + numeroPaginas + "\n" +
	           "Idioma: " + idioma + "\n" +
	           "Condição: " + getCondicao();
	}


}
