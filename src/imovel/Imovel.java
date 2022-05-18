package imovel;

public abstract class Imovel {

    double metragem;
    int codigo;
    int nQuartos;
    int nBanheiros;
    String endereco;
    private static int codigoIncremental = 0;

    public Imovel(String endereco, double metragem, int nQuartos, int nBanheiros){
        this.endereco = endereco;
        this.metragem = metragem;
        this. nQuartos = nQuartos;
        this.nBanheiros = nBanheiros;
        this.codigo = codigoIncremental;
        codigoIncremental++;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getEndereco(){
        return endereco;
    }
}
