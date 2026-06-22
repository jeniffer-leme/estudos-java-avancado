package exercicios.beluzo.ex12;

public class Cliente {
    private int codigo;
    private String nome;
    private double deposito;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    @Override
    public String toString() {
        return "Código: " + getCodigo() + "\n" +
                "Nome: " + getNome() + "\n" + 
                "Valor: " + getDeposito();
    }
}
