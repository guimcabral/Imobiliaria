package imovel;

public abstract class Imovel {

    double metragem;
    int codigo;
    int nQuartos;
    int nBanheiros;
    String endereco;
    private int codigoIncremental = 0;

    public int getCodigo(){
        return codigo;
    }

    public String getEndereco(){
        return endereco;
    }
}
