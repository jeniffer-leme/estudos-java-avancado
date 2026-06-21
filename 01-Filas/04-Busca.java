import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Busca {
    public static void main(String[] args) {
        List<Integer> busca = new ArrayList();
        
        Scanner sc = new Scanner(System.in);
        
        busca.add(10);
        busca.add(20);
        busca.add(30);
        busca.add(40);
        busca.add(50);
        busca.add(60);
        busca.add(70);
        busca.add(80);
        busca.add(90);
        busca.add(100);
        
        System.out.println("====BUSCAS====");
        
        System.out.print("Digite um valor: ");
        int num = sc.nextInt();
        
        if(busca.contains(num)) {
            System.out.println("Valor " + num + " encontrado!");
            System.out.println("Posição: " + busca.indexOf(num));
        } else {
            System.out.println("Valor não foi encontrado!");
        }
    }
}
