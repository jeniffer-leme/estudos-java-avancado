import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerCaracter {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new FileReader("arquivo.txt"));
        
        String linha;
        int contador = 0;
        
        while((linha = br.readLine()) != null) {
            if(linha.contains("!")) {
                break;
            }
            System.out.println(linha);
            contador++;
        }
        br.close();
        System.out.println("\nTotal de linhas até o !: " + contador);
    }
}
