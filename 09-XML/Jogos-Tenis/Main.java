import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XmlManager manager = new XmlManager();
        Menu menu = new Menu();
        
        int opcao = -1;

        while (opcao != 0) {
            menu.exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:
                    manager.criarXML();
                    break;

                case 2:
                    System.out.print("Digite o ID do jogo: ");
                    String id = scanner.nextLine();
                    System.out.print("Nome do Jogador 1: ");
                    String j1 = scanner.nextLine();
                    System.out.print("Nome do Jogador 2: ");
                    String j2 = scanner.nextLine();
                    System.out.print("Placar (ex: 6-4 6-3): ");
                    String placar = scanner.nextLine();
                    System.out.print("Nome da Quadra: ");
                    String quadra = scanner.nextLine();
                    
                    System.out.println();
                    manager.adicionarJogo(id, j1, j2, placar, quadra);
                    break;

                case 3:
                    manager.listarJogos();
                    break;

                case 4:
                    System.out.print("Digite o ID do jogo que quer alterar o placar: ");
                    String idPlacar = scanner.nextLine();
                    System.out.print("Digite o novo placar: ");
                    String novoPlacar = scanner.nextLine();
                    
                    System.out.println();
                    manager.alterarPlacar(idPlacar, novoPlacar);
                    break;

                case 5:
                    System.out.print("Digite o ID do jogo que quer alterar a quadra: ");
                    String idQuadra = scanner.nextLine();
                    System.out.print("Digite o nome da nova quadra: ");
                    String novaQuadra = scanner.nextLine();
                    
                    System.out.println();
                    manager.alterarQuadra(idQuadra, novaQuadra);
                    break;

                case 6:
                    System.out.print("Digite o ID do jogo que deseja remover: ");
                    String idRemover = scanner.nextLine();
                    
                    System.out.println();
                    manager.removerJogo(idRemover);
                    break;

                case 7:
                    System.out.print("Digite o ID do jogo que deseja buscar: ");
                    String idBuscar = scanner.nextLine();
                    
                    System.out.println();
                    manager.buscarJogo(idBuscar);
                    break;

                case 8:
                    manager.contarJogos();
                    break;

                case 0:
                    System.out.println("Saindo do sistema do torneio...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
