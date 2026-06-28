import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = "alunos.txt";
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
                bw.write("<alunos>\n</alunos>");
                bw.close();
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("========= MENU =========");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Exibir relatório");
            System.out.println("0 - Sair");
            System.out.println("------------------------");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println();

            if (opcao == 1) {
                System.out.print("Nome do aluno: ");
                String nome = scanner.nextLine();
                System.out.print("Nota: ");
                double nota = scanner.nextDouble();
                scanner.nextLine(); 
              
                List<String> linhas = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        linhas.add(linha);
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler para gravação: " + e.getMessage());
                }

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
                    for (int i = 0; i < linhas.size(); i++) {
                        if (linhas.get(i).trim().equals("</alunos>")) {
                            bw.write("  <aluno>\n");
                            bw.write("    <nome>" + nome + "</nome>\n");
                            bw.write("    <nota>" + nota + "</nota>\n");
                            bw.write("  </aluno>\n");
                        }
                        bw.write(linhas.get(i) + "\n");
                    }
                    System.out.println("\n• Aluno cadastrado com sucesso!\n");
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o aluno: " + e.getMessage());
                }

            } else if (opcao == 2) {
                List<Alunos> listaAlunos = new ArrayList<>();
                
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    Alunos alunoAtual = null;

                    while ((linha = br.readLine()) != null) {
                        linha = linha.trim();
                        
                        if (linha.equals("<aluno>")) {
                            alunoAtual = new Alunos();
                        } else if (linha.startsWith("<nome>") && alunoAtual != null) {
                            String nome = linha.replace("<nome>", "").replace("</nome>", "");
                            alunoAtual.setNome(nome);
                        } else if (linha.startsWith("<nota>") && alunoAtual != null) {
                            String notaStr = linha.replace("<nota>", "").replace("</nota>", "");
                            alunoAtual.setNota(Double.parseDouble(notaStr));
                        } else if (linha.equals("</aluno>") && alunoAtual != null) {
                            listaAlunos.add(alunoAtual);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo: " + e.getMessage());
                }

                if (listaAlunos.isEmpty()) {
                    System.out.println("\nNenhum aluno cadastrado até o momento.");
                    continue;
                }

                System.out.println("====== RELATÓRIO DE NOTAS ======");
                System.out.println("Lista de alunos:");
                
                double somaNotas = 0.0;
                double maiorNota = -1.0;
                String nomeMaiorNota = "";
                int alunosAprovados = 0;

                for (Alunos a : listaAlunos) {
                    System.out.printf("- %s | Nota: %.1f\n", a.getNome(), a.getNota());
                    
                    somaNotas += a.getNota();
                    
                    if (a.getNota() > maiorNota) {
                        maiorNota = a.getNota();
                        nomeMaiorNota = a.getNome();
                    }
                    
                    if (a.getNota() >= 7.0) {
                        alunosAprovados++;
                    }
                }

                double mediaTurma = somaNotas / listaAlunos.size();

                System.out.println("-------------------------------------");
                System.out.printf("• Média das notas: %.2f\n", mediaTurma);
                System.out.println("• Aluno com maior nota: " + nomeMaiorNota + " - " + maiorNota);
                System.out.println("• Alunos com nota maior ou igual a 7: " + alunosAprovados);
                System.out.println("=====================================\n");

            } else if (opcao != 0) {
                System.out.println("Opção inválida!\n");
            }
        }

        System.out.println("Sistema encerrado.");
        scanner.close();
    }
}
