package ifmt.cba.pi1.vo;

import ifmt.cba.pi1.util.data.DataUtil;

public class EntregaVO{
    private int codigo;
    private DataUtil dataPrevista;
    private DataUtil dataRealizada;
    private String arquivo;
    private TipoEntregaVO tipo;
    



public EntregaVO(){
    this.codigo = 0;
    this.dataPrevista = null;
    this.dataRealizada = null;
    this.arquivo = " ";
    this.tipo = TipoEntregaVO.parcial;
}

public EntregaVO(int codigo,DataUtil dataPrevista , DataUtil dataRealizada, String arquivo, TipoEntregaVO tipo){
    this();
    this.codigo = codigo;
    this.dataPrevista = dataPrevista;
    this.dataRealizada = dataRealizada;
    this.arquivo = arquivo;
    this.tipo = tipo;
}

public int getCodigo(){
    return codigo;
}

public void setcodigo (int codigo){
    this.codigo = codigo;
}

public DataUtil getDataPrevista(){
    return dataPrevista;
}

public void setDataPrevista (DataUtil dataPrevista){
    this.dataPrevista = dataPrevista;
}

public DataUtil getDataRealizada(){
    return dataRealizada;
}

public void setDataRealizada (DataUtil dataRealizada){
    this.dataRealizada = dataRealizada;
}

public String getArquivo (){
    return arquivo;
}

public void setArquivo (String arquivo){
    this.arquivo = arquivo;
}

public TipoEntregaVO getTipo(){
    return tipo;
}
public void setTipo(TipoEntregaVO tipo){
    this.tipo = tipo;
}

}
