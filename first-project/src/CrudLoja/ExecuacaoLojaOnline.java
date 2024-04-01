package CrudLoja;

import CrudLoja.Produtos.Produto;
import CrudLoja.Usuarios.PerfilUsuario;
import CrudLoja.Usuarios.Usuario;

import java.util.List;
import java.util.Scanner;

//1 - Realizar Login ou Register de usuario
//      Register - Cadastrar (Nome,Email,Senha,Perfil)
//      Login - Passar email e senha e ver se já existe alguem cadastrado
//      Ao fazer o login definir quem será o UsuarioLogado
//
//  2 - Caso o usuario logado seja FUNCIONARIO
//      Deve aparecer opção de cadastrar, listar, atualizar e deletar produtos
//      Tambem deve aparecer uma opção de logout, na qual o sistema voltara para de de login e registro, e ao mesmo tempo tirar o ususario logado

//
//  3 - Caso o usuario logado seja CLIENTE
//     Deve aparecer opções para comprar produtos (Ao comprar deve salvar na lista de profutos do usuario)
//     Listar produtos que foram comprados
//     Exibir total comprado
public class ExecuacaoLojaOnline {
    static Scanner scanner = new Scanner(System.in);
    static Loja loja = new Loja("Lojinha do Victor");

    public static void main(String[] args) {
        executarProgramaDeCrud();


    }

    static public void executarProgramaDeCrud() {
        boolean programaEstaAtivo = true;

        System.out.println("Bem vindo ao programa de execução da " + loja.getNome());

        while (programaEstaAtivo) {


            System.out.println("1 - Cadastrar novo usuario");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Encerrar programa");

            String escolhaDoUsuario = pegarEscolhaDoUsuarioAPartirDasOpcoes("Escolha uma das opções acima:", new String[]{"1", "2", "3"});

            if (textoIgual(escolhaDoUsuario, "1")) {
                Usuario novoUsuario = cadstrarNovoUsuario();
                loja.getUsuarios().add(novoUsuario);

            }

            if (textoIgual(escolhaDoUsuario, "2")) {
                if (loginUsuario()){
                    executarPrograma();

                }else {
                    System.out.println("E-mail ou senha invalidos, tente novamente");

                }

            }

            if (textoIgual(escolhaDoUsuario, "3")){
                System.out.println("O programa foi encerrado com sucesso!");
                programaEstaAtivo = false;
            }




        }

    }

    public static void executarPrograma(){
      if( loja.getUsuarioLogado().getPerfil() == PerfilUsuario.CLIENTE) {
            exibirFuncionalidadesParaCliente();
      }

      if (loja.getUsuarioLogado().getPerfil() == PerfilUsuario.FUNCIONARIO){
          exibirFuncionalidadesParaFuncionario();

      }

    }

    public static void exibirFuncionalidadesParaCliente(){
        // O processo deve se repetir ate o cliente deslogar
        System.out.println("Opções para CLIENTES:");
        System.out.println("1 - Comprar Produtos");
        System.out.println("2 - Listar produtos que foram comprados");
        System.out.println("3 - Exibir total comprado");
        System.out.println("4 - Logout");

        String escolhaDoCliente = pegarEscolhaDoUsuarioAPartirDasOpcoes("Escolha uma das opções disponiveis para o CLIENTE:", new String[]{"1", "2", "3"});

        if(textoIgual(escolhaDoCliente, "1")){
            // O usuario deve escolher o produto que quer comprar
            // E para o usuario selecionar ele deve saber quais são os produtos disponiveis, na loja
            //Pegar  a escolha do usuario e adicionar na lista.

            // Para o usuario escolher o produto que deseja compra, ele tem que ter acesso a lista de produtos da loja.
            //Atráves da lista que  o cliente tiver acesso, ele vai selecionar um produto dentro dela a partir do codigo.
            //Pegar o produto selecionado pelo cliente e adicionar na lista de produtos do cliente.

            listarProdutos(loja.getProdutos());
            int numeroInformado = receberNumeroNoConsole("Qual o codigo do produto desejado");
            int posicaoDoProduto =  procurarPosicaoDoProdutoNaListaApartirDoCodigo(numeroInformado, loja.getProdutos());

            if(posicaoDoProduto == -1){
                System.out.println("Codigo informado não pertence a nenhum produto cadastrado.");

            }else{
                Produto produtoSelecionadoPeloUsuario = loja.getProdutos().remove(posicaoDoProduto);


                loja.getUsuarioLogado().getProdutos().add(produtoSelecionadoPeloUsuario);
                System.out.println(" O produto " + produtoSelecionadoPeloUsuario.getNome() + " foi comprado com sucesso! ");
            }





        }

        if(textoIgual(escolhaDoCliente, "2")){

            listarProdutos(loja.getUsuarioLogado().getProdutos());

        }

    if(textoIgual(escolhaDoCliente, "3")){

        System.out.println(" o total comprado foi de: R$ " + calcularTotalCompra());
    }


    }

    public static void exibirFuncionalidadesParaFuncionario(){
        // O processo deve se repetir até o funcionario deslogar

        boolean programaEstaAtivo = true;

        while (programaEstaAtivo) {

            System.out.println("Opções para FUNCIONARIOS:");
            System.out.println("1 - Cadastrar Produto");  // Aqui vamos manipular a lista de produtos da nossa loja
            System.out.println("2 - Listar Produtos"); //  Aqui vamos manipular a lista de produtos da nossa loja
            System.out.println("3 - Atualizar Produto");// Aqui vamos atualizar um produto dentro da lsta da nossa loja
            System.out.println("4 - Deletar produto");// aqui vamos deletar um produto de dentro da lista da nossa loja
            System.out.println("5 - Logout");

            String escolhaDoFuncionario = pegarEscolhaDoUsuarioAPartirDasOpcoes("Escolha uma das opções disponiveis para o FUNCIONARIO:", new String[]{"1", "2", "3", "4", "5"});

            if (textoIgual(escolhaDoFuncionario, "1")) {
                Produto novoProduto = cadastrarNovoProduto();
                loja.getProdutos().add(novoProduto);
                System.out.println(novoProduto.getNome() + " cadastrado(a) com sucesso!");


            }

            if (textoIgual(escolhaDoFuncionario, "2")) {
                listarProdutos(loja.getProdutos());
            }

            if (textoIgual(escolhaDoFuncionario, "3")) {
                int codigoDoProduto = receberNumeroNoConsole("Informar codigo do produto");
                int posicaoProduto = procurarPosicaoDoProdutoNaListaApartirDoCodigo(codigoDoProduto, loja.getProdutos());
                if (posicaoProduto == -1) {

                    System.out.println("Nenhum produto encontrado para esse codigo!");
                } else {

                    editarProduto(posicaoProduto);

                }
            }


            if (textoIgual(escolhaDoFuncionario, "4")) {
                int codigoDoProdutoQueVaiSerRemovido = receberNumeroNoConsole("Informe o codigo do produto:");
                int posicaoDoProdutoASerRemovido = procurarPosicaoDoProdutoNaListaApartirDoCodigo(codigoDoProdutoQueVaiSerRemovido, loja.getProdutos());
                if (posicaoDoProdutoASerRemovido == -1) {

                    System.out.println("Nenhum produto encontrado para esse codigo!");
                } else {

                    loja.getProdutos().remove(posicaoDoProdutoASerRemovido);

                    System.out.println("Produto deletado com sucesso!");

                }

            }

            if(textoIgual(escolhaDoFuncionario, "5")){
                System.out.println("O programa foi encerrado!");
                programaEstaAtivo = false;

            }
        }
    }

    private static Usuario cadstrarNovoUsuario() {

        String nome = receberUmTextoDoConsole("Informe seu nome:");

        String email = receberUmTextoDoConsole("Informe seu E-mail:");

        Integer senha = receberNumeroNoConsole("Informe sua nova senha:");

        PerfilUsuario perfil = escolherSeOUsuarioEClienteOuFuncionario();


        Usuario novoUsuario = new Usuario(nome, email, senha, perfil);

        return novoUsuario;


    }

    public static String receberUmTextoDoConsole(String pergunta) {
        System.out.println(pergunta);
        String textoInformado = scanner.nextLine();

        return textoInformado;
    }

    public static int receberNumeroNoConsole(String pergunta) {
        System.out.println(pergunta);
        int numeroInformado = scanner.nextInt();


        return numeroInformado;
    }

    public static PerfilUsuario escolherSeOUsuarioEClienteOuFuncionario() {
        System.out.println("Cadastrar como Cliente ou Funcionario:");

        System.out.println("C - Cliente");
        System.out.println("F - Funcionario");

        String escolhaDoUsuario = pegarEscolhaDoUsuarioAPartirDasOpcoes("Informe sua resposta:", new String[]{"C", "F"});
        return escolhaDoUsuario.equals("C") ? PerfilUsuario.CLIENTE : PerfilUsuario.FUNCIONARIO;


    }

    public static String pegarEscolhaDoUsuarioAPartirDasOpcoes(String pergunta, String[] opcoes) {
        boolean continuarPedirEscolhaDoUsuario = true;
        String escolhaDoUsuario;

        do {
            escolhaDoUsuario = receberUmTextoDoConsole(pergunta);

            if (verificarSeOpcaoEValida(escolhaDoUsuario, opcoes)) {
                continuarPedirEscolhaDoUsuario = false;
            } else {
                System.out.println("Opção invalida!");
            }

        } while (continuarPedirEscolhaDoUsuario);

        return escolhaDoUsuario;
    }

    public static boolean verificarSeOpcaoEValida(String opcao, String[] opcoes) {
        for (int i = 0; i < opcoes.length; i++) {
            if (opcao.equals(opcoes[i])) {
                return true;

            }
        }
        return false;
    }

    public static boolean textoIgual(String texto1, String texto2) {
        return texto1.equals(texto2);
    }

    public static boolean loginUsuario() {

        String email = receberUmTextoDoConsole("Informe seu E-mail");

        String senha = receberUmTextoDoConsole("Informe sua senha");

        return verificarLoginDoUsuarioEAdicionarUsuarioLogado(email, senha, loja.getUsuarios());


    }

    public static boolean verificarLoginDoUsuarioEAdicionarUsuarioLogado(String email, String senha, List<Usuario> usuarios) {
        for (Usuario usuario : loja.getUsuarios()) {

            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {

                loja.setUsuarioLogado(usuario);

                return true;
            }
        }

        return false;
    }

    public void adicionarProdutoNaLista(Produto produto){
        loja.getUsuarioLogado().getProdutos().add(produto);

    }

    public static double calcularTotalCompra(){
        double total = 0;
        for (Produto produto: loja.getUsuarioLogado().getProdutos()){
            total += produto.getValor();
        }
        return total;
    }

    public static void listarProdutos(List<Produto> produtos){
        System.out.println("Lista de produtos cadastrados:");

        for (Produto produto : produtos){
            System.out.println(produto);
        }
    }

    public static int procurarPosicaoDoProdutoNaListaApartirDoCodigo(int codigo, List<Produto> produtos){

        for (int i = 0; i <produtos.size();  i++) {
            if (produtos.get(i).getCodigo() == codigo){
                return i;
            }
        }
        return -1;
    }

    public static Produto cadastrarNovoProduto(){
        String nome = receberUmTextoDoConsole("Informe o nome do produto");

        String descricao = receberUmTextoDoConsole("Informe uma descrição para o novo produto:");

        double valor = receberNumeroNoConsole("Informe o valor desejado para o novo produto:");

        Produto produto = new Produto(nome, descricao, valor);

        return produto;
    }

    public static void editarProduto(int posicaoProduto){

        System.out.println("Passe as novas informações do produto");

        String nome = receberUmTextoDoConsole("Informe o nome do produto");

        String descricao = receberUmTextoDoConsole("Informe uma nova descrição para o produto:");

        double valor = receberNumeroNoConsole("Informe o novo valor desejado para o 1produto:");

        loja.getProdutos().get(posicaoProduto).setNome(nome);
        loja.getProdutos().get(posicaoProduto).setDescricao(descricao);
        loja.getProdutos().get(posicaoProduto).setValor(valor);

        System.out.println("Produto atualizado com sucesso!");
    }

}











