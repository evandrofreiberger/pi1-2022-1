package ifmt.cba.pi1.negocio;

import ifmt.cba.pi1.vo.ProfessorVO;

public class ProfessorNegocio {
    
    protected String validarDados(ProfessorVO professorVO) {
        String mensagemErros = "";

        if (professorVO.getMatricula() == null || professorVO.getMatricula().length() == 0) {
			mensagemErros += "Matricula não pode ser nula";
		}

		if (professorVO.getNome() == null || professorVO.getNome().length() == 0) {
			mensagemErros += "Nome do Convidado nao pode ser vazio";
		}

        return mensagemErros;
    }
}
