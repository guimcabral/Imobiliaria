package usuario;

public class Cliente {

    private String cpf;
    private String nome;

    public Cliente(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
}
