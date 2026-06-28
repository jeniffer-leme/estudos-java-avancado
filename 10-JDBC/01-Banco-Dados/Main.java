import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("========= MENU BANCO DE DADOS =========");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Buscar Cliente por ID");
            System.out.println("0 - Sair");
            System.out.println("---------------------------------------");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("====== CADASTRO DE PRODUTO ======");
                    System.out.print("Nome do produto: ");
                    String nomeProd = scanner.nextLine();
                    System.out.print("Preço: ");
                    double precoProd = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtdProd = scanner.nextInt();
                    scanner.nextLine(); 

                    String sqlCadastro = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

                    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                         PreparedStatement stmt = conn.prepareStatement(sqlCadastro)) {
                        
                        stmt.setString(1, nomeProd);
                        stmt.setDouble(2, precoProd);
                        stmt.setInt(3, qtdProd);

                        int linhasAfetadas = stmt.executeUpdate();
                        
                        if (linhasAfetadas > 0) {
                            System.out.println("\n• Produto cadastrado com sucesso no banco de dados!");
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao conectar ou cadastrar produto: " + e.getMessage());
                    }
                    System.out.println("=================================\n");
                    break;

                case 2:
                    System.out.println("====== BUSCA DE CLIENTE ======");
                    System.out.print("Digite o ID do cliente: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine(); 

                    String sqlBusca = "SELECT nome, email FROM clientes WHERE id = ?";

                    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                         PreparedStatement stmt = conn.prepareStatement(sqlBusca)) {
                        
                        stmt.setInt(1, idCliente);

                        try (ResultSet rs = stmt.executeQuery()) {
                            if (rs.next()) {
                                String nomeCli = rs.getString("nome");
                                String emailCli = rs.getString("email");

                                System.out.println("\nCliente Encontrado:");
                                System.out.println("• Nome: " + nomeCli);
                                System.out.println("• Email: " + emailCli);
                            } else {
                                System.out.println("\n❌ Nenhum cliente encontrado com o ID " + idCliente);
                            }
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao conectar ou buscar cliente: " + e.getMessage());
                    }
                    System.out.println("==============================\n");
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        }

        scanner.close();
    }
}
