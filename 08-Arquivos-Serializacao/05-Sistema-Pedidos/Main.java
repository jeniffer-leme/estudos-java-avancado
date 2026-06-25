package exercicios.beluzo.ex29;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {

        Produto p1 = new Produto("Notebook", 4500.00);
        Produto p2 = new Produto("Mouse Gamer", 150.50);
        
        Pedido meuPedido = new Pedido(1024); 
        meuPedido.adicionarProduto(p1);
        meuPedido.adicionarProduto(p2);
        
        System.out.println("Gravando o pedido no arquivo...");
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pedido.ser"));
        oos.writeObject(meuPedido); 
        oos.close();
        
        System.out.println("Pedido salvo com sucesso!\n");
        System.out.println("----------------------------------------");
        System.out.println("Lendo e desserializando o arquivo...\n");
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pedido.ser"));
        Pedido pedidoRecuperado = (Pedido) ois.readObject(); // Conversão para a classe Pedido
        ois.close();
        
        System.out.println("======= RESUMO DO PEDIDO RECUPERADO =======");
        System.out.println("Código do Pedido: " + pedidoRecuperado.getCodigo());
        System.out.println("Produtos inclusos:");
        
        for (Produto p : pedidoRecuperado.getListaProduto()) {
            System.out.println(" - " + p.getNome() + ": R$ " + p.getPreco());
        }
        
        System.out.printf("Valor Total do Pedido: R$ %.2f\n", pedidoRecuperado.getValorTotal());
        System.out.println("===========================================");
    }
}
