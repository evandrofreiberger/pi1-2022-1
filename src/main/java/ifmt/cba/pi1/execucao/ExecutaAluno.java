package ifmt.cba.pi1.execucao;

import ifmt.cba.pi1.negocio.AlunoNegocio;
import ifmt.cba.pi1.negocio.CursoNegocio;
import ifmt.cba.pi1.negocio.NegocioException;
import ifmt.cba.pi1.vo.AlunoVO;
import ifmt.cba.pi1.vo.CursoVO;

public class ExecutaAluno {
    public static void main(String[] args) {
        try {

            CursoVO cursoVO = criaCurso("Engenharia da Controle");
            CursoVO cursoVO2 = criaCurso("algebra");

            criaAluno("Rui", cursoVO);
            criaAluno("Eduardo", cursoVO);

            criaAluno("Mario", cursoVO2);
            criaAluno("Ana", cursoVO2);


            System.out.println("Inclusão validada");
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void criaAluno(String nome, CursoVO cursoVO) throws NegocioException {
        AlunoNegocio alunoNegocio = new AlunoNegocio();
        AlunoVO alunoVO = new AlunoVO();
        alunoVO.setCursoVO(cursoVO);
        alunoVO.setNome(nome);
        alunoNegocio.inserir(alunoVO);
    }

    private static CursoVO criaCurso(String nome) throws NegocioException {
        CursoNegocio cursoNegocio = new CursoNegocio();
        CursoVO cursoVO = new CursoVO();
        cursoVO.setNome(nome);
        cursoNegocio.inserir(cursoVO);
        return cursoVO;
    }
}
