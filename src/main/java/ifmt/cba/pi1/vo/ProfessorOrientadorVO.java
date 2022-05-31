package ifmt.cba.pi1.vo;

import java.util.List;

public class ProfessorOrientadorVO extends ProfessorVO {
    private List listTCC;

    public List getList() {
        return listTCC;
    }

    public void setList(List list) {
        this.listTCC = list;
    }
    public ProfessorOrientadorVO(List list) {
        this.listTCC = list;
    }

    public ProfessorOrientadorVO(String matricula, String nome, DepartamentoVO departamento, String email, String fone,
            List list) {
        super(matricula, nome, departamento, email, fone);
        this.listTCC = list;
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
        ProfessorOrientadorVO other = (ProfessorOrientadorVO) obj;
        if (listTCC == null) {
            if (other.listTCC != null)
                return false;
        } else if (!listTCC.equals(other.listTCC))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProfessorOrientadorVO [list=" + listTCC + "]";
    }
    
    
}
