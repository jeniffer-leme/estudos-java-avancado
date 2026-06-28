import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlManager {
    private final String PATH = "jogos.xml";

    private void salvarXML(Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(PATH));
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println("Erro ao salvar o arquivo XML: " + e.getMessage());
        }
    }

    private Document obterDocumento() {
        try {
            File arquivo = new File(PATH);
            if (!arquivo.exists()) {
                return null;
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(arquivo);
            doc.getDocumentElement().normalize();
            return doc;
        } catch (Exception e) {
            System.out.println("Erro ao carregar o arquivo XML: " + e.getMessage());
            return null;
        }
    }

    public void criarXML() {
        try {
            File arquivo = new File(PATH);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element raiz = doc.createElement("torneio");
            doc.appendChild(raiz);

            salvarXML(doc);
            System.out.println("• Arquivo 'jogos.xml' criado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar XML: " + e.getMessage());
        }
    }

    public void adicionarJogo(String id, String jogador1, String jogador2, String placar, String quadra) {
        Document doc = obterDocumento();
        if (doc == null) {
            System.out.println("ERRO: O arquivo XML não existe. Crie o arquivo primeiro (Opção 1).");
            return;
        }

        NodeList nList = doc.getElementsByTagName("jogo");
        
        for (int i = 0; i < nList.getLength(); i++) {
            Element el = (Element) nList.item(i);
            if (el.getAttribute("id").equals(id)) {
                System.out.println("ERRO: Já existe um jogo com este ID.");
                return;
            }
        }

        Element novoJogo = doc.createElement("jogo");
        novoJogo.setAttribute("id", id);

        Element j1 = doc.createElement("jogador1");
        j1.setTextContent(jogador1);
        novoJogo.appendChild(j1);

        Element j2 = doc.createElement("jogador2");
        j2.setTextContent(jogador2);
        novoJogo.appendChild(j2);

        Element pl = doc.createElement("placar");
        pl.setTextContent(placar);
        novoJogo.appendChild(pl);

        Element qd = doc.createElement("quadra");
        qd.setTextContent(quadra);
        novoJogo.appendChild(qd);

        doc.getDocumentElement().appendChild(novoJogo);
        salvarXML(doc);
        System.out.println("• Jogo adicionado com sucesso!");
    }

    public void listarJogos() {
        Document doc = obterDocumento();
        if (doc == null) return;

        NodeList nList = doc.getElementsByTagName("jogo");
        if (nList.getLength() == 0) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        System.out.println("====== LISTA DE JOGOS ======");
        for (int i = 0; i < nList.getLength(); i++) {
            Element el = (Element) nList.item(i);
            System.out.println("ID: " + el.getAttribute("id"));
            System.out.println("Jogador 1: " + el.getElementsByTagName("jogador1").item(0).getTextContent());
            System.out.println("Jogador 2: " + el.getElementsByTagName("jogador2").item(0).getTextContent());
            System.out.println("Placar: " + el.getElementsByTagName("placar").item(0).getTextContent());
            System.out.println("Quadra: " + el.getElementsByTagName("quadra").item(0).getTextContent());
            System.out.println("------------------------");
        }
    }

    public void alterarPlacar(String id, String novoPlacar) {
        Document doc = obterDocumento();
        if (doc == null) return;

        NodeList nList = doc.getElementsByTagName("jogo");
        boolean encontrado = false;

        for (int i = 0; i < nList.getLength(); i++) {
            Element el = (Element) nList.item(i);
            if (el.getAttribute("id").equals(id)) {
                el.getElementsByTagName("placar").item(0).setTextContent(novoPlacar);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            salvarXML(doc);
            System.out.println("• Placar alterado com sucesso!");
        } else {
            System.out.println("Jogo com ID " + id + " não encontrado.");
        }
    }

    public void alterarQuadra(String id, String novaQuadra) {
        Document doc = obterDocumento();
        if (doc == null) return;

        NodeList nList = doc.getElementsByTagName("jogo");
        boolean encontrado = false;

        for (int i = 0; i < nList.getLength(); i++) {
            Element el = (Element) nList.item(i);
            if (el.getAttribute("id").equals(id)) {
                el.getElementsByTagName("quadra").item(0).setTextContent(novaQuadra);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            salvarXML(doc);
            System.out.println("• Quadra alterada com sucesso!");
        } else {
            System.out.println("Jogo com ID " + id + " não encontrado.");
        }
    }

    public void removerJogo(String id) {
        Document doc = obterDocumento();
        if (doc == null) return;

        NodeList nList = doc.getElementsByTagName("jogo");
        boolean encontrado = false;

        for (int i = 0; i < nList.getLength(); i++) {
            Element el = (Element) nList.item(i);
            if (el.getAttribute("id").equals(id)) {
                Node raiz = doc.getDocumentElement();
                raiz.removeChild(el);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            salvarXML(doc);
            System.out.println("• Jogo removido com sucesso!");
        } else {
            System.out.println("Jogo com ID " + id + " não encontrado.");
        }
    }

    public void buscarJogo(String id) {
        Document doc = obterDocumento();
        if (doc == null) return;

        NodeList nList = doc.getElementsByTagName("jogo");
        boolean encontrado = false;

        for (int i = 0; i < nList.getLength(); i++) {
            Element el = (Element) nList.item(i);
            if (el.getAttribute("id").equals(id)) {
                System.out.println("====== JOGO ENCONTRADO ======");
                System.out.println("ID: " + el.getAttribute("id"));
                System.out.println("Jogador 1: " + el.getElementsByTagName("jogador1").item(0).getTextContent());
                System.out.println("Jogador 2: " + el.getElementsByTagName("jogador2").item(0).getTextContent());
                System.out.println("Placar: " + el.getElementsByTagName("placar").item(0).getTextContent());
                System.out.println("Quadra: " + el.getElementsByTagName("quadra").item(0).getTextContent());
                System.out.println("=============================");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Jogo com ID " + id + " não encontrado.");
        }
    }

    public void contarJogos() {
        Document doc = obterDocumento();
        if (doc == null) {
            System.out.println("Quantidade de jogos cadastrados: 0");
            return;
        }
        NodeList nList = doc.getElementsByTagName("jogo");
        System.out.println("Quantidade de jogos cadastrados: " + nList.getLength());
    }
}
