package ifmt.cba.pi1.execucao;

import ifmt.cba.pi1.negocio.AlunoNegocio;
import ifmt.cba.pi1.negocio.NegocioException;
import ifmt.cba.pi1.vo.AlunoVO;

public class ExecutaAluno 
{
    public static void main( String[] args ) {
        try {
            AlunoNegocio alunoNegocio = new AlunoNegocio();
            AlunoVO alunoVO = new AlunoVO();

            alunoVO.setMatricula(123456);
            alunoVO.setNome("Fulano das Quantas");
            
            alunoNegocio.inserir(alunoVO);
            
            System.out.println("Inclusão validada");
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
    }
}
