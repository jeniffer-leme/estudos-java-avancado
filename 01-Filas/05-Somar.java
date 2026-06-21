import java.util.ArrayList;
import java.util.List;

public class Somar {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList();
        
        numeros.add(3);
        numeros.add(6);
        numeros.add(9);
        numeros.add(12);
        numeros.add(15);
        numeros.add(18);
        numeros.add(21);
        numeros.add(24);
        
        System.out.println("====NÚMEROS====");
        for(Integer numero : numeros) {
            System.out.println(numero);
        }
        
        int soma = 0;
        for(int i = 0; i < numeros.size(); i++) {
            soma += numeros.get(i);
        }
        
        System.out.println();
        
        System.out.println("Soma: " + soma);
    }
}
