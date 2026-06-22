import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Map<String, String> user = new HashMap();
        
        Scanner sc = new Scanner(System.in);
        
        user.put("Paulo", "lua571");
        user.put("Thiago", "4786flor");
        user.put("Carla", "LuTa75");
        
        System.out.println("==== LOGIN ====");
        System.out.print("Digite o usuario: ");
        String usuario = sc.nextLine();
        
        System.out.print("Digite a senha: ");
        String senha = sc.nextLine();
        
        if(user.containsKey(usuario)) {
            String senhaCorreta = user.get(usuario);
            
            if(senhaCorreta.equals(senha)) {
                System.out.println("Login realizado com sucesso!");
            } else {
                System.out.println("Senha incorreta!");
            }
        } else {
            System.out.println("Usuário incorreto!");
        }
    }
}
