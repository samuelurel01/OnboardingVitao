package CrudLoja;

import CrudLoja.Usuarios.PerfilUsuario;
import CrudLoja.Usuarios.Usuario;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.ArrayList;
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
        escolherSeOUsuarioEClienteOuFuncionario();
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

    }

    public static void exibirFuncionalidadesParaFuncionario(){

        System.out.println("Opções para FUNCIONARIOS:");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Atualizar Produto");
        System.out.println("4 - Deletar produto");
        System.out.println("5 - Logout");
    }

    private static Usuario cadstrarNovoUsuario() {

        String nome = receberUmTextoDoConsole("Informe seu nome:");

        String email = receberUmTextoDoConsole("Informe seu E-mail:");

        Integer senha = receberNumeroNoConsole("Informe sua nova senha:");

        PerfilUsuario perfil = escolherSeOUsuarioEClienteOuFuncionario();


        Usuario novoUsuario = new Usuario();

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

}










