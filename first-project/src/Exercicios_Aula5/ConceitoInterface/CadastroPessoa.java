package Exercicios_Aula5.ConceitoInterface;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoa implements Cadastro {

    private List<Pessoa> pessoasCadastradas = new ArrayList<>();

    public void criarNovaPessoa(String nome, Integer idade, GeneroEnum generoEnum){
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(nome);
        novaPessoa.setIdade(idade);
        novaPessoa.setGenero(generoEnum);

         this.pessoasCadastradas.add(novaPessoa);
    }

    public void listarPessoas() {
        for (Pessoa pessoa: pessoasCadastradas) {
            System.out.println(pessoa);
        }
    }

    public List<Pessoa> getPessoasCadastradas() {
        return pessoasCadastradas;
    }

    public void setPessoasCadastradas(List<Pessoa> pessoasCadastradas) {
        this.pessoasCadastradas = pessoasCadastradas;
    }
}
