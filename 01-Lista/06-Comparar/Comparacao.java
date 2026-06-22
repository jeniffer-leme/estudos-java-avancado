import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Comparacao {
    public static void main(String[] args) {
        List<Integer> listaArray = new ArrayList<>();
        List<Integer> listaLinked = new LinkedList<>();
        
        int tamanho = 10000;
        
        for(int i = 0; i < tamanho; i++) {
            listaArray.add(i);
            listaLinked.add(i);
        }
        
        long inicioArray = System.currentTimeMillis();
        
        for(int i = 0; i < tamanho; i++) {
            listaArray.get(i);
        }
        
        long fimArray = System.currentTimeMillis();
        
        
        
        long inicioLinked = System.currentTimeMillis();
        
        for(int i = 0; i < tamanho; i++) {
            listaLinked.get(i);
        }
        
        long fimLinked = System.currentTimeMillis();
        
        System.out.println("Tempo ArrayList: " + (fimArray - inicioArray) + " ms");
        System.out.println("Tempo LinkedList: " + (fimLinked - inicioLinked) + " ms");
    }
}
