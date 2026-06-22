public class Acesso {
    public enum NivelAcesso {
            ADMIN,
            USUARIO,
            VISITANTE
    }
    
    
    public static void main(String[] args) {
        NivelAcesso acessar;
        
        acessar = NivelAcesso.ADMIN;
        
        System.out.println("Nível de acesso: " + acessar);
    }
}
