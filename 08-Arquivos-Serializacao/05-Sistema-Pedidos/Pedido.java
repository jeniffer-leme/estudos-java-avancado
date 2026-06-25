package exercicios.beluzo.ex29;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
    public static final long serialVersionUID = 1L;
    
    ArrayList<Produto> listaProduto = new ArrayList<>();
    int codigo;

    public Pedido(int codigo) {
        setCodigo(codigo);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void adicionarProduto(Produto p) {
        this.listaProduto.add(p);
    }

    public double getValorTotal() {
        double total = 0;
        for (Produto p : listaProduto) {
            total += p.getPreco();
        }
        return total;
    }
}
