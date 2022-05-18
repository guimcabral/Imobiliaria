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

        String box;

        if(temBox)
            box = "Sim";
        else
            box = "Não";

        return "Código: " + codigo + "\n" +
                "Endereço: " + endereco + "\n" +
                "Metragem: " + metragem + "\n" +
                "Número de quartos: " + nQuartos + "\n" +
                "Número de banheiros: " + nBanheiros + "\n" +
                "Andar: " + andar + "\n" +
                "Box: " + box;
    }
}
