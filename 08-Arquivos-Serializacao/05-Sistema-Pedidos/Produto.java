package exercicios.beluzo.ex29;

import java.io.Serializable;

public class Produto implements Serializable {
    public static final long serialVersionUID = 1L;
    
    private String nome;
    double preco;

    public Produto(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
