package ifmt.cba.pi1.vo;

public class CursoVO {
    private int codigo;
    private String nome;



public CursoVO(){
    this.codigo = 0;
    this.nome = " ";
}

public CursoVO(int codigo, String nome){
    this();
    this.codigo = codigo;
    this.nome = nome;
}

    public int getCodigo(){
        return codigo;
    }

    public void setcodigo (int codigo){
        this.codigo = codigo;
    }

    public String getNome (){
        return nome;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

}
