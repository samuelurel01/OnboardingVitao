package primeirocrudSQL.application;

public class Application {

    public static void main(String[] args) {
        Conexao conexao = new Conexao("jdbc:mysql://localhost:3306/teste", "root", "vitor");
        ProgramaVenda programaVenda = new ProgramaVenda(conexao.criarConexao());
        programaVenda.executar();


        ScannerUtils.receberUmTextoDoConsole("Qual carro voce quer comprar");

    }
}
