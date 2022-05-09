package ifmt.cba.pi1.vo;

public class EnderecoVO {

    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private EnumUF uf;

    public EnderecoVO() {
        this.logradouro = "";
        this.numero = 0;
        this.bairro = "";
        this.cidade = "";
        this.uf = EnumUF.MT;
    }

    public EnderecoVO(String logradouro, int numero, String bairro, String cidade, EnumUF uf) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public EnumUF getUf() {
        return uf;
    }

    public void setUf(EnumUF uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return this.logradouro + ", " + this.numero+ ", " +this.bairro + " ," +
                this.cidade+ "-" +this.uf;
    }

    
}
