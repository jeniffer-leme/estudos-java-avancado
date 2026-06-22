import java.util.Scanner;

public class Localizar {
    public static void main(String[] args) {
        int [] vetor = new int[5];
        Scanner sc = new Scanner(System.in);
        
        vetor[0] = 3;
        vetor[1] = 6;
        vetor[2] = 9;
        vetor[3] = 12;
        vetor[4] = 15;
        
        try {
            System.out.print("Digite um índice [0 - 4]: ");
            int indice = sc.nextInt();
            
            System.out.println("Índice: " + indice);
            System.out.println("Valor: " + vetor[indice]);
            
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Índice inválido!");
        }
    }
}
