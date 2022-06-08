package ifmt.cba.pi1.vo;

import java.util.Objects;

import ifmt.cba.pi1.util.data.DataUtil;

public class InterrupcaoVO {

	private Integer codigo;
	private DataUtil data;
	private String motivo;

	private TCCVO tcc;

	public InterrupcaoVO() {
		this.codigo = 0;
		this.motivo = "";
		this.data = null;
	}

	public InterrupcaoVO(Integer codigo, DataUtil data, String motivo, TCCVO tcc) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.motivo = motivo;
		this.tcc = tcc;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public DataUtil getData() {
		return data;
	}

	public void setData(DataUtil data) {
		this.data = data;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public TCCVO getTcc() {
		return tcc;
	}

	public void setTcc(TCCVO tcc) {
		this.tcc = tcc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterrupcaoVO other = (InterrupcaoVO) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
	
	
}
