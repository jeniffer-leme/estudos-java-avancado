package exercicios.beluzo.ex16;

public class Alunos {
    private String disciplina;
    private Double nota;

    public String getDisciplina() {
        return disciplina;
    }

    public Double getNota() {
        return nota;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Disciplina: " + getDisciplina() + "\n" +
                "Nota: " + getNota() + "\n";
    }
    
    
}
