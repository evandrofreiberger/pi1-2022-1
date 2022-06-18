package ifmt.cba.pi1.vo;

import javax.persistence.*;

@Entity
@Table(name = "aluno")
public class AlunoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int matricula;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoVO cursoVO;

    public AlunoVO() {
        this.nome = "";
        this.cursoVO = new CursoVO();
    }


    public AlunoVO(String nome) {
        this();
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
        return matricula + " - " + nome;
    }

    public CursoVO getCursoVO() {
        return cursoVO;
    }

    public void setCursoVO(CursoVO cursoVO) {
        this.cursoVO = cursoVO;
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
