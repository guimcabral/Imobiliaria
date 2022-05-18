package imovel;

public abstract class Imovel {

    double metragem;
    int codigo;
    int nQuartos;
    int nBanheiros;
    String endereco;
    //TODO: O atributo codigo segue um comportamento incremental (implementado utilizando codigoIncremental).
    private int codigoIncremental = 0;

    public Imovel(String endereco, double metragem, int nQuartos, int nBanheiros){
        this.endereco = endereco;
        this.metragem = metragem;
        this. nQuartos = nQuartos;
        this.nBanheiros = nBanheiros;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getEndereco(){
        return endereco;
    }
}
