package exercicios.beluzo.ex03;

import java.util.LinkedList;
import java.util.List;

public class Cidades {
    public static void main(String[] args) {
        LinkedList<String> cidade = new LinkedList();
        
        cidade.add("Nova York");
        cidade.add("Araraquara");
        cidade.add("Roma");
        cidade.add("Salvador");
        
        System.out.println("====CIDADES====");
        for(String cidades : cidade) {
            System.out.println(cidades);
        }
        
        System.out.println("----------------------");
        
        cidade.add(1, "Seul");
        
        System.out.println("====CIDADES====");
        for(String cidades : cidade) {
            System.out.println(cidades);
        }
    }
}
