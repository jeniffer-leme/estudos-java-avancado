import java.util.HashMap;
import java.util.Map;

public class Alunos {
    public static void main(String[] args) {
        Map<String, String> alunos = new HashMap();
    
        alunos.put("Aq3047103", "Bruna");
        alunos.put("Aq3047107", "Luan");
        alunos.put("Aq3047109", "Catarina");
        alunos.put("Aq3047114", "Luis");
        alunos.put("Aq3047117", "Roberta");
        alunos.put("Aq3047120", "Pedro");
        
        String ra1 = alunos.get("Aq3047109");
        String ra2 = alunos.get("Aq3047120");
        
        
        System.out.println("==== BUSCAR RA ====");
        System.out.println("Nome: " + ra1);
        System.out.println("Nome: " + ra2);
        
        System.out.println();
        
        System.out.println("==== ALUNOS ====");
        for(Map.Entry<String, String> a : alunos.entrySet()) {
            System.out.println("RA: " + a.getKey());
            System.out.println("Nome: " + a.getValue());
            
            System.out.println("------------------------------------");
        }
    }
}
