import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Cliente> cliente = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        int opcao;
        
        do {
            System.out.println("====== FILA DE DEPÓSITO ======");
            System.out.println("1. Entrar na fila");
            System.out.println("2. Próximo da fila");
            System.out.println("3. Atender o próximo");
            System.out.println("4. Fila atual");
            System.out.println("0. Sair");
            
            System.out.print("\nDigite a opção que deseja: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("\n----- ENTRAR NA FILA -----");
                    
                    Cliente c1 = new Cliente();
                    
                    System.out.print("Digite o código: ");
                    int novoCodigo = sc.nextInt();
                    sc.nextLine();
                    c1.setCodigo(novoCodigo);
                    
                    System.out.print("Digite o nome: ");
                    String novoNome = sc.nextLine();
                    c1.setNome(novoNome);
                    
                    System.out.print("Digite o valor do depósito: ");
                    double novoValor = sc.nextDouble();
                    c1.setDeposito(novoValor);
                    
                    cliente.add(c1);
                    
                    System.out.println("\nCliente cadastrado com sucesso!\n");
                    break;
                    
                case 2:
                    System.out.println("\n----- PRÓXIMO DA FILA -----");
                    System.out.println(cliente.peek());
                    
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.println("\n----- ATENDER PRÓXIMO DA FILA -----");
                    System.out.println(cliente.poll());
                    
                    System.out.println();
                    break;
                    
                case 4:
                    System.out.println("\n----- FILA ATUAL -----");
                    for(Cliente c : cliente) {
                        System.out.println(c);
                        System.out.println("------------------------------------");
                    }
                    
                    System.out.println();
                    break;
                    
                case 0:
                    System.out.println("Você saiu!");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            
        }while(opcao != 0);
    }
}
