package exercicios.beluzo.ex16;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
        Map<String, Map<String, Double>> sistemaNotas = new HashMap<>();

        Map<String, Double> a1 = new HashMap<>();
        a1.put("Português", 8.5);
        a1.put("Matemática", 7.0);
        a1.put("História", 9.0);
        
        sistemaNotas.put("Aq3047107", a1);

        Map<String, Double> a2 = new HashMap<>();
        a2.put("Português", 6.0);
        a2.put("Matemática", 8.0);
        a2.put("História", 7.5);
        
        sistemaNotas.put("Aq3047109", a2);

        Map<String, Double> a3 = new HashMap<>();
        a3.put("Português", 9.5);
        a3.put("Matemática", 9.0);
        a3.put("História", 10.0);
        
        sistemaNotas.put("Aq3047114", a3);

        System.out.println("====== RELATÓRIO DE NOTAS ======\n");

        for (String ra : sistemaNotas.keySet()) {
            System.out.println("RA do Aluno: " + ra);
            System.out.println("------------------------");
            
            Map<String, Double> notasDesteAluno = sistemaNotas.get(ra);
            
            double soma = 0.0;
            
            for (String disciplina : notasDesteAluno.keySet()) {
                double nota = notasDesteAluno.get(disciplina);
                System.out.println(disciplina + ": " + nota);
                soma += nota; 
            }
            
            double media = soma / notasDesteAluno.size();
            System.out.printf("MÉDIA FINAL: %.2f\n", media);
            System.out.println("========================\n");
        }
        
        String raMaiorMedia = "";
        double maiorMediaGeral = -1.0; 
        double maiorNotaDaTurma = -1.0;
        double somaMediasSala = 0.0;

        System.out.println("====== RELATÓRIO DE NOTAS ======\n");

        for (String ra : sistemaNotas.keySet()) {
            System.out.println("RA do Aluno: " + ra);
            System.out.println("------------------------");
            
            Map<String, Double> notasDesteAluno = sistemaNotas.get(ra);
            double somaNotasAluno = 0.0;
            
            for (String disciplina : notasDesteAluno.keySet()) {
                double nota = notasDesteAluno.get(disciplina);
                System.out.println(disciplina + ": " + nota);
                
                somaNotasAluno += nota;
                
                if (nota > maiorNotaDaTurma) {
                    maiorNotaDaTurma = nota;
                }
            }
            
            double mediaAluno = somaNotasAluno / notasDesteAluno.size();
            System.out.printf("MÉDIA FINAL: %.2f\n", mediaAluno);
            System.out.println("========================\n");
            
            somaMediasSala += mediaAluno;
            
            if (mediaAluno > maiorMediaGeral) {
                maiorMediaGeral = mediaAluno;
                raMaiorMedia = ra;
            }
        }

        double mediaDaSala = somaMediasSala / sistemaNotas.size();

        System.out.println("====== RESULTADO DO DESAFIO ======");
        System.out.println("• Aluno com a maior média: RA " + raMaiorMedia + " (Média: " + String.format("%.2f", maiorMediaGeral) + ")");
        System.out.println("• Maior nota individual da turma: " + maiorNotaDaTurma);
        System.out.printf("• Média geral da Sala: %.2f\n", mediaDaSala);
        System.out.println("=====================================");
    
    }
}
