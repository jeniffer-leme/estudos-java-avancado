import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Nomes {
    public static void main(String[] args) throws IOException {
        ArrayList<String> nomes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("arquivo.txt"));
        System.out.print("Digite os nomes (0 - Sair): ");
        
        while(true) {
            String texto = sc.nextLine();
            
            if(texto.equals("0")) {
                System.out.println("Você saiu!");
                break;
            } 
            bw.write(texto + "\n");
        }
        bw.close();
    }
}
