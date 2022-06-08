package ifmt.cba.pi1.vo;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "curso")
public class CursoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(nullable = false,length = 50)
    private String nome;


    public CursoVO() {
        this.nome = "";
    }


    public CursoVO(String nome) {
        this.nome = nome;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoVO cursoVO = (CursoVO) o;
        return codigo == cursoVO.codigo && nome.equals(cursoVO.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome);
    }

    @Override
    public String toString() {
        return "CursoVO{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
