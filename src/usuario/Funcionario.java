package usuario;

public class Funcionario {

    private int senha;
    private int codigo;
    private boolean autenticado;

    public Funcionario(int codigo){
        this.codigo = codigo;
    }

    public boolean isAutenticado(){
        return autenticado;
    }
}
