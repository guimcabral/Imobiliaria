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

        String patio;
        String garagem;

        if(temPatio)
            patio = "Sim";
        else
            patio = "Não";

        if(temGaragem)
            garagem = "Sim";
        else
            garagem = "Não";

        return "Código: " + codigo + "\n" +
                "Endereço: " + endereco + "\n" +
                "Metragem: " + metragem + "\n" +
                "Número de quartos: " + nQuartos + "\n" +
                "Número de banheiros: " + nBanheiros + "\n" +
                "Pátio: " + patio + "\n" +
                "Garagem: " + garagem;
    }
}
