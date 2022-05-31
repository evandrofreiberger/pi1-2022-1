package ifmt.cba.pi1.vo;

import java.util.List;

public class ProfessorDisciplinaVO extends ProfessorVO{
    private List listTCC;

    public List getListTCC() {
        return listTCC;
    }

    public void setListTCC(List listTCC) {
        this.listTCC = listTCC;
    }

    public ProfessorDisciplinaVO() {
    }

    public ProfessorDisciplinaVO(String matricula, String nome, DepartamentoVO departamento, String email,
            String fone) {
        super(matricula, nome, departamento, email, fone);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((listTCC == null) ? 0 : listTCC.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProfessorDisciplinaVO other = (ProfessorDisciplinaVO) obj;
        if (listTCC == null) {
            if (other.listTCC != null)
                return false;
        } else if (!listTCC.equals(other.listTCC))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProfessorDisciplinaVO [listTCC=" + listTCC + "]";
    }
    
}
