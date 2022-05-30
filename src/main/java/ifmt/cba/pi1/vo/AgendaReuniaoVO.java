package ifmt.cba.pi1.vo;

import java.sql.Time;
import java.util.Date;

public class AgendaReuniaoVO {
	private int codigo;
	private Date dataPrevista;
	private Time hora;
	private String assunto;

	public AgendaReuniaoVO() {
		this.codigo = 0;
		this.assunto = " ";
	}

	public AgendaReuniaoVO(int codigo, Date dataPrevista, Time hora, String assunto) {
		this();
		this.codigo = codigo;
		this.dataPrevista = dataPrevista;
		this.hora = hora;
		this.assunto = assunto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

}
