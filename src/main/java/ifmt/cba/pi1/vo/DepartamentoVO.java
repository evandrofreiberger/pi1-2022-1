package ifmt.cba.pi1.vo;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoVO {

	//Atributos;
	private Integer codigo;
	private String nome;
	private String sigla;
	
	private List<ProfessorVO> professores = new ArrayList<>();
	
	public DepartamentoVO() {
        this.codigo = 0;
        this.nome = "";
        this.sigla = "";
    }
	
	public DepartamentoVO(Integer codigo, String nome,String sigla ) {
        this();
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<ProfessorVO> getProfessores() {
		return professores;
	}

	public void setProfessores(List<ProfessorVO> professores) {
		this.professores = professores;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartamentoVO other = (DepartamentoVO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DepartamentoVO [codigo=" + codigo + 
				", nome=" + nome + ", sigla=" + sigla + "]" +
				"Professor= " + this.getProfessores();
	}
	
	
	
	
}
