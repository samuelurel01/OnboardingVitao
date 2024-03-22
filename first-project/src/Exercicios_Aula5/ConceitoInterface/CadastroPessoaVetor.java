package Exercicios_Aula5.ConceitoInterface;

public class CadastroPessoaVetor implements Cadastro {

    private int ultimaPosicaoSalva = -1;

    private Pessoa[] pessoasCadastradas = new Pessoa[100];

    @Override
    public void criarNovaPessoa(String nome, Integer idade, GeneroEnum generoEnum) {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(nome);
        novaPessoa.setIdade(idade);
        novaPessoa.setGenero(generoEnum);

        ultimaPosicaoSalva++;
        this.pessoasCadastradas[ultimaPosicaoSalva] = novaPessoa;
    }

    @Override
    public void listarPessoas() {
        for (int i = 0; i < pessoasCadastradas.length; i++) {
            if(pessoasCadastradas[i] != null){
                System.out.println(pessoasCadastradas[i]);
            }
        }
    }

    public int getUltimaPosicaoSalva() {
        return ultimaPosicaoSalva;
    }

    public void setUltimaPosicaoSalva(int ultimaPosicaoSalva) {
        this.ultimaPosicaoSalva = ultimaPosicaoSalva;
    }

    public Pessoa[] getPessoasCadastradas() {
        return pessoasCadastradas;
    }

    public void setPessoasCadastradas(Pessoa[] pessoasCadastradas) {
        this.pessoasCadastradas = pessoasCadastradas;
    }


}
