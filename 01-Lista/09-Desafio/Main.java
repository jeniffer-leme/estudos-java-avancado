import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Produto> produto = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Produto p1 = new Produto();
        
        int opcao;
        
        do {
            System.out.println("\n===== CADASTRO PRODUTOS =====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produto");
            System.out.println("3. Buscar Produto");
            System.out.println("4. Remover Produto");
            System.out.println("5. Mostrar valor total estoque");
            System.out.println("0. Sair");
            
            System.out.print("\nDigite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("\n---- CADASTRAR PRODUTO ----");
                    System.out.print("Digite o nome do produto: ");
                    String novoNome = sc.nextLine();
                    p1.setNome(novoNome);
                    
                    System.out.print("Digite o preço do produto: ");
                    double novoPreco = sc.nextFloat();
                    p1.setPreco(novoPreco);
                    
                    System.out.print("Digite a quantidade do produto: ");
                    int novaQtd = sc.nextInt();
                    p1.setQuantidade(novaQtd);
                    
                    produto.add(p1);
                    
                    System.out.println("\nProduto cadastrado com sucesso!\n");
                    break;
                    
                case 2:
                    System.out.println("\n---- LISTAR PRODUTOS ----");
                    for(Produto p : produto) {
                        System.out.println(p);
                    }
                    System.out.println("-----------------------------");
                    break;
                    
                case 3:
                    System.out.println("\n---- BUSCAR PRODUTO ----");
                    boolean encontrado = true;
                    System.out.print("Digite o nome do produto que deseja buscar: ");
                    String busca = sc.nextLine();
                    
                    for(Produto p : produto) {
                        if(p1.getNome().equals(busca)) {
                            System.out.println(p);
                            encontrado = true;
                            break;
                        } 
                    }
                    
                    if(!encontrado) {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                    
                case 4:
                    System.out.println("\n---- REMOVER PRODUTO ----");
                    System.out.print("Digite o produto que deseja excluir: ");
                    String remover = sc.nextLine();
                    
                    produto.removeIf(p -> p.getNome().equals(remover));
                    break;
                    
                case 5:
                    System.out.println("\n---- VALOR TOTAL ----");
                    double soma = 0;
                    
                    for(Produto p : produto) {
                        soma += p1.getPreco();
                    }
                    
                    System.out.println("Soma dos produtos: " + soma);
                    
                    break;
                    
                case 0:
                    System.out.println("Você saiu!");
                    break;
                    
                default:
                    throw new AssertionError();
            }
            
        }while(opcao != 0);
    }
}
