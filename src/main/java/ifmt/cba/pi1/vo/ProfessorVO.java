package ifmt.cba.pi1.vo;

public class ProfessorVO {
	private String matricula;
	private String nome;
	private DepartamentoVO departamento;
	private String email;
	private String fone;
	
	public ProfessorVO() {
        this.matricula = "";
        this.nome = "";
        this.email = "";
        this.fone = "";
        
    }

	public ProfessorVO(String matricula, String nome, DepartamentoVO departamento, String email, String fone) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.departamento = departamento;
		this.email = email;
		this.fone = fone;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DepartamentoVO getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoVO departamento) {
		this.departamento = departamento;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		ProfessorVO other = (ProfessorVO) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProfessorVO [matricula=" + matricula + ", nome=" + nome + ", departamento=" + departamento + ", email="
				+ email + ", fone=" + fone + "]";
	}
	
	
	
	
	
	
	
	
}
