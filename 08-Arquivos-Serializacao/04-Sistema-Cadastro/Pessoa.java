package exercicios.beluzo.ex28;

import java.io.Serializable;

public class Pessoa implements Serializable {
    public static final long serialVersionUID = 1L;
    
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
    }
    
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n" +
                "Idade: " + getIdade();
    }
}
