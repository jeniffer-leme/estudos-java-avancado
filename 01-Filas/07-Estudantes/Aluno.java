public class Aluno {
    String nome;
    int idade;
    String curso;

    public Aluno(String nome, int idade, String curso) {
        setNome(nome);
        setIdade(idade);
        setCurso(curso);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "Curso: " + curso;
    }
    
    
}
