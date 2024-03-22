package Exercicios_Aula5.ConceitoInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadastroPessoaMap implements Cadastro {

    private Map<String,Pessoa> pessoasCadastradas = new HashMap<>();

    @Override
    public void criarNovaPessoa(String nome, Integer idade, GeneroEnum generoEnum){
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(nome);
        novaPessoa.setIdade(idade);
        novaPessoa.setGenero(generoEnum);

         this.pessoasCadastradas.put(nome,novaPessoa);
    }

    @Override
    public void listarPessoas() {
        for(Map.Entry<String,Pessoa> entry : pessoasCadastradas.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public Map<String, Pessoa> getPessoasCadastradas() {
        return pessoasCadastradas;
    }

    public void setPessoasCadastradas(Map<String, Pessoa> pessoasCadastradas) {
        this.pessoasCadastradas = pessoasCadastradas;
    }


}
