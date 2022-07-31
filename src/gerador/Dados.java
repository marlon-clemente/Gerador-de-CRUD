package gerador;

public class Dados {
    String tipo;
    String nome;
    

    public Dados(String tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Dados{" + "nome=" + nome + '}';
    }
    
    
       
}
