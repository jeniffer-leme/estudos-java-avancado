public class Alunos {
    private String nome;
    private Double nota;

    public String getNome() {
        return nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n" +
               "Nota: " + getNota() + "\n";
    }
}
