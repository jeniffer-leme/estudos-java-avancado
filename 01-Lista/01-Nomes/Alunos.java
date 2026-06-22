import java.util.ArrayList;
import java.util.List;

public class Alunos {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList();
        
        nomes.add("Maria");
        nomes.add("Alef");
        nomes.add("Camilla");
        nomes.add("Gustavo");
        nomes.add("Victor");
        
        System.out.println("=====ALUNOS=====");
        for( String nome : nomes) {
            System.out.println(nome);
        }
        
        System.out.println();
        
        System.out.println("Tamanho da lista: " + nomes.size());
        
        System.out.println("--------------------------------");
        
        nomes.remove("Gustavo");
        
        System.out.println("=====ALUNOS=====");
        for(String nome : nomes) {
            System.out.println(nome);
        }
        
        System.out.println();
        
        System.out.println("Tamanho da lista: " + nomes.size());
    }
}
