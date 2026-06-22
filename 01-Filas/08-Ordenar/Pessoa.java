import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pessoa {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList();
        
        nomes.add("Maria");
        nomes.add("Lucas");
        nomes.add("Zuzu");
        nomes.add("Bruna");
        nomes.add("Ana");
        nomes.add("Denis");
        
        System.out.println("Desordenado:");
        System.out.println("====NOMES====");
        for(String nome : nomes) {
            System.out.println(nome);
        }
        
        System.out.println("-----------------------------");
        
        Collections.sort(nomes);
        
        System.out.println("Ordenado: ");
        System.out.println("====NOMES====");
        for(String nome : nomes) {
            System.out.println(nome);
        }
    }
}
