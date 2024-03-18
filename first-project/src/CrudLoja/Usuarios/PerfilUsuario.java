package CrudLoja.Usuarios;

public enum PerfilUsuario {
    CLIENTE("Cliente"),
    FUNCIONARIO("Funcionario");

    private String perfilUsuario;

    PerfilUsuario(String perfilUsuario){
        this.perfilUsuario = perfilUsuario;
    }

    @Override
    public String toString() {
        return this.perfilUsuario;
    }
}
