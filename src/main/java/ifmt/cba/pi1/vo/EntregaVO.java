package ifmt.cba.pi1.vo;
import java.util.Date;

public class EntregaVO{
    private int codigo;
    private Date dataPrevista;
    private Date dataRealizada;
    private String arquivo;
    private TipoEntregaVO tipo;
    



public EntregaVO(){
    this.codigo = 0;
    this.dataPrevista = x;
    this.dataRealizada = y;
    this.arquivo = " ";
    this.tipo = TipoEntregaVO.parcial;
}

public EntregaVO(int codigo,Date dataPrevista , Date dataRealizada, String arquivo, TipoEntregaVO tipo){
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

public Date getDataPrevista(){
    return dataPrevista;
}

public void setDataPrevista (Date dataPrevista){
    this.dataPrevista = dataPrevista;
}

public Date getDataRealizada(){
    return dataRealizada;
}

public void setDataRealizada (Date dataRealizada){
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
    this.tipo = tipo
}

}
