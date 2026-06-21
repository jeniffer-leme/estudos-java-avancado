import java.util.ArrayList;
import java.util.List;

public class Numeros {
    public static void main(String[] args) {
        List<Integer> numero = new ArrayList();
        
        numero.add(12);
        numero.add(3);
        numero.add(89);
        numero.add(21);
        numero.add(0);
        numero.add(29);
        numero.add(45);
        numero.add(9);
        numero.add(52);
        numero.add(90);
        
        System.out.println("1° Elemento: " + numero.getFirst());
        System.out.println("Último Elemento: " + numero.getLast());
        System.out.println("5° Elemento: " + numero.get(4));
    }
}
