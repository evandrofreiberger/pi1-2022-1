package ifmt.cba.pi1.vo;

public class ConvidadoVO {
	private int codigo;
	private String nome;
	private String email;
	private String fone;
	private String recomendacoes;
	private String observacoes;
	private int nota;
	private int codigoAcesso;

	public ConvidadoVO() {
		  nome = "";
		  email = "";
		  fone= "";
		  recomendacoes= "";
		  observacoes= "";
		  nota= 0;
		  codigoAcesso= 0;
	}

	public ConvidadoVO(String nome, String email, String fone, String recomendacoes, String observacoes, int nota,
			int codigoAcesso) {
		super();
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.recomendacoes = recomendacoes;
		this.observacoes = observacoes;
		this.nota = nota;
		this.codigoAcesso = codigoAcesso;
	}

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getRecomendacoes() {
		return recomendacoes;
	}

	public void setRecomendacoes(String recomendacoes) {
		this.recomendacoes = recomendacoes;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getCodigoAcesso() {
		return codigoAcesso;
	}

	public void setCodigoAcesso(int codigoAcesso) {
		this.codigoAcesso = codigoAcesso;
	}
}
