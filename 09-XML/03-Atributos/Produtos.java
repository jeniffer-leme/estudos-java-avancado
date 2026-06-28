public class Produtos {
    private String id;
    private String categoria;
    private String tempoPreparo;
    private String promocao;
    private String nome;
    private Double preco;
    private Boolean disponivel;

    public String getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTempoPreparo() {
        return tempoPreparo;
    }

    public String getPromocao() {
        return promocao;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTempoPreparo(String tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\n" +
               "Nome: " + getNome() + "\n" +
               "Preço: " + getPreco() + "\n";
    }
}
