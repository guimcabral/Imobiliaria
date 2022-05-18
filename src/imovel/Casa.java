package imovel;

public class Casa extends Imovel{

    private boolean temPatio;
    private boolean temGaragem;

    public Casa(String endereco, double metragem, int nQuartos, int nBanheiros, boolean temPatio, boolean temGaragem) {
        super(endereco, metragem, nQuartos, nBanheiros);
        this.temPatio = temPatio;
        this.temGaragem = temGaragem;
    }


    public String toString(){
        return "";
    }
}
