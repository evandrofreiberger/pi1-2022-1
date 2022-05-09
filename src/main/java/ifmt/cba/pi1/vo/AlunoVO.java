package ifmt.cba.pi1.vo;

public class AlunoVO {

    private int matricula;
    private String nome;
    
    public AlunoVO() {
        this.matricula = 0;
        this.nome = "";
    }

    public AlunoVO(int matricula, String nome) {
        this();
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return matricula +" - "+ nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + matricula;
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
        AlunoVO other = (AlunoVO) obj;
        if (matricula != other.matricula)
            return false;
        return true;
    }

   
}
