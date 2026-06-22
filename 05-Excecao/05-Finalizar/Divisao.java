import java.util.Scanner;

public class Divisao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
   
        System.out.print("Digite um valor: ");
        double valor = sc.nextDouble();
        
        System.out.print("Digite um valor: ");
        double valor2 = sc.nextDouble();
        
        double resultado = 0.0;
        
        
        try {
            if(valor2 == 0) {
                throw new ArithmeticException();
            }
            
            resultado = valor / valor2;
            
            System.out.printf("Resultado: %.2f\n", resultado);
            
        } catch(ArithmeticException e) {
            System.out.println("Erro: Não é posível dividir por zero!");
        
        } finally {
            System.out.println("\nPrograma finalizado!");
        }
    }
}
