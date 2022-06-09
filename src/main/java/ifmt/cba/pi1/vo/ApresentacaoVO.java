package ifmt.cba.pi1.vo;

import ifmt.cba.pi1.util.data.DataUtil;

import java.sql.Time;
import java.util.List;

public class ApresentacaoVO{

    private int codigo;
    private String local;
    private float media;
    private DataUtil data;
    private Time hora;
    private TCCVO tcc;
    private List<ConvidadoVO> ListConvidado;

    public List<ConvidadoVO> getListConvidado() {
        return ListConvidado;
    }

    public void setListConvidado(List<ConvidadoVO> ListConvidado) {
        this.ListConvidado = ListConvidado;
    }

    public ApresentacaoVO() {
        this.codigo = 0;
        this.local= " ";
        this.media= 0;
    }

    public ApresentacaoVO(int codigo, String local, float media, DataUtil data, Time hora, TCCVO tcc, List<ConvidadoVO> listConvidado) {
        this.codigo = codigo;
        this.local = local;
        this.media = media;
        this.data = data;
        this.hora = hora;
        this.tcc = tcc;
        ListConvidado = listConvidado;
    }

    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(){
        this.codigo = codigo;
    }

    public String getLocal(){
        return local;
    }
    public void setLocal(){
        this.local = local;
    }

    public float getMedia(){
        return media;
    }
    public void setMedia(){
        this.media = media;
    }
    public DataUtil getData(){
        return data;
    }
    public void setData(){
        this.data = data;
    }

    public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

    public TCCVO getTcc() {
		return tcc;
	}

	public void setTcc(TCCVO tcc) {
		this.tcc = tcc;
	}


}
