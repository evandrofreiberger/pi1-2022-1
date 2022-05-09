package ifmt.cba.pi1.execucao;

import ifmt.cba.pi1.negocio.AlunoNegocio;
import ifmt.cba.pi1.negocio.NegocioException;
import ifmt.cba.pi1.vo.AlunoVO;
import ifmt.cba.pi1.vo.EnumSexo;
import ifmt.cba.pi1.vo.EnumUF;

public class ExecutaAluno 
{
    public static void main( String[] args ) {
        try {
            AlunoNegocio alunoNegocio = new AlunoNegocio();
            AlunoVO alunoVO = new AlunoVO();

            alunoVO.setNome("Fulano das Quantas");
            alunoVO.setNomeMae("Mae do Fulano das Quantas");
            alunoVO.setNomePai("Pai do Fulano das Quantas");
            alunoVO.setSexo(EnumSexo.MASCULINO);
            alunoVO.getEndereco().setLogradouro("Rua das flores");
            alunoVO.getEndereco().setNumero(10);
            alunoVO.getEndereco().setBairro("Centro");
            alunoVO.getEndereco().setCidade("Cuiaba");
            alunoVO.getEndereco().setUf(EnumUF.MT);
            
            alunoNegocio.inserir(alunoVO);
            
            System.out.println("Inclusão validada");
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
    }
}
