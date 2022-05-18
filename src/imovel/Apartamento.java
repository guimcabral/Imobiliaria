package imovel;

public class Apartamento extends Imovel{

    private int andar;
    private boolean temBox;

    public Apartamento(String endereco, double metragem, int nQuartos, int nBanheiros, int andar, boolean temBox) {
        super(endereco, metragem, nQuartos, nBanheiros);
        this.andar = andar;
        this.temBox = temBox;
    }

    public String toString(){
        return "";
    }
}
