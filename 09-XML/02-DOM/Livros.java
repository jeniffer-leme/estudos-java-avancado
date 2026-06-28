public class Livros {
    private String titulo;
    private String autor;
    private Double preco;

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo() + "\n" +
               "Autor: " + getAutor() + "\n" +
               "Preço: " + getPreco() + "\n";
    }
}
