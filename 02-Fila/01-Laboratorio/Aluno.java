import java.util.LinkedList;
import java.util.Queue;

public class Aluno {
    public static void main(String[] args) {
        Queue<String> aluno = new LinkedList<>();
        
        aluno.add("Rafaela");
        aluno.add("Bruno");
        aluno.add("Lucas");
        
        System.out.println("==== FILA ATUAL DO LABORATÓRIO ====");
        for(String nome : aluno) {
            System.out.println(nome);
        }
        
        System.out.println("---------------------------------");
        
        System.out.println("Primeiro aluno: " + aluno.peek());
        System.out.println("Atendendo: " + aluno.poll());
        
        System.out.println("---------------------------------");
        
        System.out.println("==== FILA ATUAL DO LABORATÓRIO ====");
        for(String nome : aluno) {
            System.out.println(nome);
        }
    }
}
