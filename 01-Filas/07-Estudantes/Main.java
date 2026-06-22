import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Aluno> aluno = new ArrayList();
        
        Aluno a1 = new Aluno("Romeu", 21, "Licenciatura");
        Aluno a2 = new Aluno("Bruna", 19, "Administração");
        Aluno a3 = new Aluno("Manuel", 25, "ADS");
        
        aluno.add(a1);
        aluno.add(a2);
        aluno.add(a3);
        
        System.out.println("====ALUNOS====");
        for(Aluno a : aluno) {
            System.out.println(a);
            System.out.println("----------------------");
        }
    }
}
