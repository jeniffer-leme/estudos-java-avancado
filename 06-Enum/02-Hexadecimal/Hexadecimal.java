public class Valor {
    public enum Hexadecimal {
        A(10),
        B(11),
        C(12),
        D(13),
        E(14),
        F(15);
        
        private int valor;
        
        Hexadecimal(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }
    
    public static void main(String[] args) {
        Hexadecimal valor;
        
        valor = Hexadecimal.E;
        
        System.out.println("Hexadecimal: " + valor);
        System.out.println("Decimal: " + valor.getValor());
    }
}
