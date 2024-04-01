package CrudLoja.Produtos;

// Deve existir CRUD de produto, mas só quem é funcionario pode realizar isso.
public class Produto {

    private static int ultimoCodigoCriado = 0;

    // Esse código deve ser gerado automaticamente.
    private Integer codigo;

    private String nome;

    private String descricao;

    private Double valor;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    public Produto(String nome, String descricao, Double valor) {
        setNome(nome);
        setDescricao(descricao);
        setValor(valor);
        setCodigo(++ultimoCodigoCriado);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}

