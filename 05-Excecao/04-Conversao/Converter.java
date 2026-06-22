import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Digite um número: ");
        String valor = sc.nextLine();
        
        try {
            Integer.parseInt(valor);
            
            System.out.println("Valor: " + valor);
            
        } catch(NumberFormatException e) {
            System.out.println("Erro: Valor inválido!");
        }
    }
}
