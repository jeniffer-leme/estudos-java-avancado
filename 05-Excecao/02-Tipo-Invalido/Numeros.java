import java.util.InputMismatchException;
import java.util.Scanner;

public class Numeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        try {
            System.out.print("Digite um valor inteiro: ");
            int num = sc.nextInt();

            System.out.println("Número digitado: " + num);
            
        } catch(InputMismatchException e) {
            System.out.println("ERRO: Digite um valor inteiro!");
        }
    }
}
