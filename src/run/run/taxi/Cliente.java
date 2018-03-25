package run.run.taxi;

public class Cliente {

    private int codigo;
    private String nome;
    private String telefoneA;
    private String telefoneB;
    private Endereco endereco;

    public Cliente(int codigoCliente, String nome, String telefoneA, String telefoneB, Endereco endereco) {
        this.codigo = codigoCliente;
        this.nome = nome;
        this.telefoneA = telefoneA;
        this.telefoneB = telefoneB;
        this.endereco = endereco;
    }

    public Cliente(int codigoCliente, String nome) {
        this.codigo = codigoCliente;
        this.nome = nome;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefoneA() {
        return telefoneA;
    }

    public String getTelefoneB() {
        return telefoneB;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefoneA(String telefoneA) {
        this.telefoneA = telefoneA;
    }

    public void setTelefoneB(String telefoneB) {
        this.telefoneB = telefoneB;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
