import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Livros> listaLivros = new ArrayList<>();
        List<String> listaAutores = new ArrayList<>();

        try {
            File arquivo = new File("livros.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(arquivo);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("livro");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;

                    Livros livro = new Livros();
                    livro.setTitulo(elemento.getElementsByTagName("titulo").item(0).getTextContent());
                    livro.setAutor(elemento.getElementsByTagName("autor").item(0).getTextContent());
                    
                    String precoStr = elemento.getElementsByTagName("preco").item(0).getTextContent();
                    livro.setPreco(Double.parseDouble(precoStr));

                    listaLivros.add(livro);

                    if (!listaAutores.contains(livro.getAutor())) {
                        listaAutores.add(livro.getAutor());
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler ou processar o arquivo XML: " + e.getMessage());
            scanner.close();
            return;
        }

        double somaTotal = 0.0;
        double maiorPreco = -1.0;
        String tituloLivroMaisCaro = "";

        for (Livros l : listaLivros) {
            somaTotal += l.getPreco();

            if (l.getPreco() > maiorPreco) {
                maiorPreco = l.getPreco();
                tituloLivroMaisCaro = l.getTitulo();
            }
        }

        System.out.println("====== CATÁLOGO DE LIVROS ======");
        System.out.println("Autores disponíveis:");
        for (int i = 0; i < listaAutores.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaAutores.get(i));
        }
        System.out.println("--------------------------------");
        System.out.print("Escolha o índice do autor: ");
        int indiceEscolhido = scanner.nextInt();
        System.out.println();

        if (indiceEscolhido > 0 && indiceEscolhido <= listaAutores.size()) {
            String autorSelecionado = listaAutores.get(indiceEscolhido - 1);

            System.out.println("====== RELATÓRIO DO CATÁLOGO ======");
            System.out.printf("Soma total dos preços: R$ %.2f\n\n", somaTotal);

            System.out.println("Livros do autor " + autorSelecionado + ":");
            for (Livros l : listaLivros) {
                if (l.getAutor().equals(autorSelecionado)) {
                    System.out.println("- " + l.getTitulo());
                }
            }

            System.out.println("\nLivro mais caro:");
            System.out.printf("%s - R$ %.2f\n", tituloLivroMaisCaro, maiorPreco);
            System.out.println("===================================\n");
            
        } else {
            System.out.println("Índice de autor inválido!");
        }

        scanner.close();
    }
}
