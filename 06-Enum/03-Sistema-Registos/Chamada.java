import Enum.Prioridade;
import Enum.Status_Chamado;
import Enum.Tipo_Problema;

public class Chamada {
    private static int contadorId = 1; 
    private int id;
    private String descricao;
    private Prioridade prioridade;
    private Status_Chamado status;
    private Tipo_Problema tipo;

    public Chamada(String descricao, Prioridade prioridade, Status_Chamado status, Tipo_Problema tipo) {
        this.id = contadorId++;
        setDescricao(descricao);
        setPrioridade(prioridade);
        setStatus(status);
        setTipo(tipo);
    }
    
    public int getId() {
        return id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public Status_Chamado getStatus() {
        return status;
    }

    public Tipo_Problema getTipo() {
        return tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public void setStatus(Status_Chamado status) {
        this.status = status;
    }

    public void setTipo(Tipo_Problema tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Descrição: " + getDescricao() + "\n" + 
                "Prioridade: " + getPrioridade() + "\n" +
                "Status: " + getStatus() + "\n" +
                "Tipo: " + getTipo();
    }    
}
