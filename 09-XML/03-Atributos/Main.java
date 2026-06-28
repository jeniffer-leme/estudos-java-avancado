import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
    public static void main(String[] args) {
        List<Produtos> cardapio = new ArrayList<>();

        try {
            File arquivo = new File("cardapio.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(arquivo);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("produto");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;

                    Produtos produto = new Produtos();
                    
                    produto.setId(elemento.getAttribute("id"));
                    produto.setCategoria(elemento.getAttribute("categoria"));
                    produto.setTempoPreparo(elemento.getAttribute("tempoPreparo"));
                    produto.setPromocao(elemento.getAttribute("promocao"));

                    produto.setNome(elemento.getElementsByTagName("nome").item(0).getTextContent());
                    
                    String precoStr = elemento.getElementsByTagName("preco").item(0).getTextContent();
                    produto.setPreco(Double.parseDouble(precoStr));
                    
                    String dispStr = elemento.getElementsByTagName("disponivel").item(0).getTextContent();
                    produto.setDisponivel(Boolean.parseBoolean(dispStr));

                    cardapio.add(produto);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao processar o arquivo XML: " + e.getMessage());
            return;
        }

        int totalItens = cardapio.size();
        int itensDisponiveis = 0;
        int itensIndisponiveis = 0;
        double somaPrecosDisponiveis = 0.0;

        System.out.println("====== CARDÁPIO DO BAR ======");

        for (int i = 0; i < cardapio.size(); i++) {
            Produtos p = cardapio.get(i);
            
            System.out.println("Item ID: " + p.getId() + " [" + p.getCategoria().toUpperCase() + "]");
            System.out.println("Nome: " + p.getNome());
            
            if (p.getPromocao() != null && p.getPromocao().equals("true")) {
                System.out.print("Preço: R$ " + String.format("%.2f", p.getPreco()) + " (🔥 EM PROMOÇÃO!)\n");
            } else {
                System.out.printf("Preço: R$ %.2f\n", p.getPreco());
            }

            if (p.getTempoPreparo() != null && !p.getTempoPreparo().isEmpty()) {
                System.out.println("Tempo de Preparo: " + p.getTempoPreparo());
            }

            if (p.getDisponivel()) {
                System.out.println("Status: DISPONÍVEL");
                itensDisponiveis++;
                somaPrecosDisponiveis += p.getPreco();
            } else {
                System.out.println("Status: INDISPONÍVEL ❌");
                itensIndisponiveis++;
            }

            System.out.println("-------------------------------------");
        }

        System.out.println("\n====== RESUMO DO CARDÁPIO ======");
        System.out.println("• Total de itens cadastrados: " + totalItens);
        System.out.println("• Itens prontos para servir: " + itensDisponiveis);
        System.out.println("• Itens em falta: " + itensIndisponiveis);
        
        if (itensDisponiveis > 0) {
            double mediaPreco = somaPrecosDisponiveis / itensDisponiveis;
            System.out.printf("• Média de preço dos itens ativos: R$ %.2f\n", mediaPreco);
        }
        
        System.out.println("=====================================");
    }
}
