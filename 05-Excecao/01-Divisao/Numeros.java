import java.util.Scanner;

public class Numeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        double num = sc.nextDouble();
        
        System.out.print("Digite um valor: ");
        double num2 = sc.nextDouble();
        
        double dividir = 0.0;
        
        try {
            if(num2 == 0) {
                throw new ArithmeticException();
            }
            
            dividir = num / num2;
            System.out.printf("Resultado: %.2f\n", dividir);
            
        } catch(ArithmeticException e) {
            System.out.println("Não é possível dividir por zero!");
        }
    }
}
