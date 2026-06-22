import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ordenar {
    public static void main(String[] args) {
        Set<String> nome = new LinkedHashSet();
        
        nome.add("Aline");
        nome.add("Vitor");
        nome.add("Rafaela");
        nome.add("Vitor");
        nome.add("Rafaela");
        nome.add("Bruna");
        
        System.out.println("==== NOMES ====");
        for(String nomes : nome) {
            System.out.println(nomes);
        }
        
        System.out.println("\n-----------------------------------------------------------------------------");
        
        Set<String> seres = new TreeSet<>();
        
        seres.add("Aline");
        seres.add("Vitor");
        seres.add("Rafaela");
        seres.add("Vitor");
        seres.add("Rafaela");
        seres.add("Bruna");
        
        System.out.println("\n==== NOMES ====");
        for(String ser : seres) {
            System.out.println(ser);
        }
    }
}
