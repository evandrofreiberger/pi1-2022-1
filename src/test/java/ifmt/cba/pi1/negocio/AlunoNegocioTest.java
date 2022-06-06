package ifmt.cba.pi1.negocio;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNoException;

import org.junit.Test;

import ifmt.cba.pi1.vo.AlunoVO;

public class AlunoNegocioTest {

    private AlunoNegocio alunoNegocio;

    @Test
    public void testAlterar() {

    }

    @Test
    public void testExcluir() {

    }

    @Test
    public void testInserir() {

        AlunoVO alunoVO = new AlunoVO();
        alunoVO.setNome("");

        
        try {
            alunoNegocio = new AlunoNegocio();
            alunoNegocio.inserir(alunoVO);
            
        } catch (NegocioException e) {
            fail(e.getMessage());
        }
        

        
    }

    @Test
    public void testPesquisaMatricula() {

    }

    @Test
    public void testPesquisaParteNome() {

    }
}
