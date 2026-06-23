import Enum.Prioridade;
import Enum.Status_Chamado;
import Enum.Tipo_Problema;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaSuporte {
    public static void main(String[] args) {
        ArrayList<Chamada> chamado = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        int opcao;
        
        do {
            System.out.println("===== MENU DE CHAMADOS =====");
            System.out.println("1. Abrir novo chamado");
            System.out.println("2. Listar chamados");
            System.out.println("3. Alterar status de um chamado");
            System.out.println("4. Buscar por descricao");
            System.out.println("5. Mostrar chamados por prioridade");
            System.out.println("0. Sair");
            
            System.out.print("\nDigite a opção desejada: ");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.println("----- NOVO CHAMADO -----");
                    System.out.print("Descrição do problema: ");
                    sc.nextLine(); 
                    String descricao = sc.nextLine();

                    System.out.println();
                    System.out.println("Selecione o Tipo de Problema:");
                    System.out.println("1 - Hardware");
                    System.out.println("2 - Software");
                    System.out.println("3 - Rede");
                    System.out.println("4 - Acesso");
                    System.out.print("Opção: ");
                    int opcaoTipo = sc.nextInt();

                    Tipo_Problema tipo = Tipo_Problema.HARDWARE; 
                    if (opcaoTipo == 2) tipo = Tipo_Problema.SOFTWARE;
                    else if (opcaoTipo == 3) tipo = Tipo_Problema.REDE;
                    else if (opcaoTipo == 4) tipo = Tipo_Problema.ACESSO;

                    System.out.println();
                    System.out.println("Selecione a Prioridade:");
                    System.out.println("1 - Baixa");
                    System.out.println("2 - Média");
                    System.out.println("3 - Alta");
                    System.out.print("Opção: ");
                    int opcaoPrioridade = sc.nextInt();

                    Prioridade prioridade = Prioridade.BAIXA; 
                    if (opcaoPrioridade == 2) prioridade = Prioridade.MEDIA;
                    else if (opcaoPrioridade == 3) prioridade = Prioridade.ALTA;

                    Chamada novoChamado = new Chamada(descricao, prioridade, Status_Chamado.ABERTO, tipo);
                    chamado.add(novoChamado);

                    System.out.println("Chamado aberto com sucesso (Status: ABERTO)!");
                    break;
                    
                case 2:
                    System.out.println("----- LISTAR CHAMADOS -----");
                    for (Chamada novo : chamado) {
                        System.out.println(novo);
                        System.out.println("---------------------------");
                    }
                    break;
                    
                case 3:
                    System.out.println("----- ALTERAR STATUS DE UM CHAMADO -----");
                    System.out.println("Escolha o número do chamado de 0 a " + (chamado.size() - 1) + ":");
                    int indice = sc.nextInt();
                    
                    if (indice >= 0 && indice < chamado.size()) {
                        System.out.println("Selecione o novo Status:");
                        System.out.println("1 - ABERTO");
                        System.out.println("2 - EM ATENDIMENTO");
                        System.out.println("3 - RESOLVIDO");
                        System.out.print("Opção: ");
                        int opcaoStatus = sc.nextInt();
                        
                        Status_Chamado novoStatus = Status_Chamado.ABERTO;
                        if (opcaoStatus == 2) novoStatus = Status_Chamado.EM_ATENDIMENTO;
                        else if (opcaoStatus == 3) novoStatus = Status_Chamado.RESOLVIDO;
                        
                        chamado.get(indice).setStatus(novoStatus);
                        System.out.println("Status alterado com sucesso!");
                    } else {
                        System.out.println("Número de chamado inválido!");
                    }
                    break;
                    
                case 4:
                    System.out.println("----- BUSCAR POR DESCRIÇÃO -----");
                    System.out.print("Digite o termo que deseja buscar: ");
                    sc.nextLine();
                    String busca = sc.nextLine();
                    
                    for (Chamada novo : chamado) {
                        if (novo.getDescricao().toLowerCase().contains(busca.toLowerCase())) {
                            System.out.println(novo);
                            System.out.println("---------------------------");
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("----- MOSTRAR CHAMADOS POR PRIORIDADE -----");
                    System.out.println("Escolha a prioridade para filtrar:");
                    System.out.println("1 - Baixa");
                    System.out.println("2 - Média");
                    System.out.println("3 - Alta");
                    System.out.print("Opção: ");
                    int opcaoFiltro = sc.nextInt();
                    
                    Prioridade filtro = Prioridade.BAIXA;
                    if (opcaoFiltro == 2) filtro = Prioridade.MEDIA;
                    else if (opcaoFiltro == 3) filtro = Prioridade.ALTA;
                    
                    for (Chamada novo : chamado) {
                        if (novo.getPrioridade() == filtro) {
                            System.out.println(novo);
                            System.out.println("---------------------------");
                        }
                    }
                    break;
                    
                case 0:
                    System.out.println("Você saiu!");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            
        } while(opcao != 0); 
        
        sc.close();
    }
}
