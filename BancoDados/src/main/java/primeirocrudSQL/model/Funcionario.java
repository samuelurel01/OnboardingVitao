package primeirocrudSQL.model;

public class Funcionario {

    private Integer id;
    private String nome;
    private String sigla;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Funcionario(Integer id, String nome, String sigla){

        setId(id);
        setNome(nome);
        setSigla(sigla);

    }
}
