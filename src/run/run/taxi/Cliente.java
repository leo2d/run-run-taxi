package run.run.taxi;
public class Cliente {

    private int codigo;
    private String nome;
    private String telefoneA;
    private String telefoneB;
    private Endereco endereco;

    public Cliente(String nome, String telefoneA, String telefoneB) {
        this.codigo += 1;
        this.nome = nome;
        this.telefoneA = telefoneA;
        this.telefoneB = telefoneB;
        this.endereco = new Endereco();
    }

    public Cliente(String nome) {
        this.codigo += 1;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
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

    public void gerarCodigo() {
        //this.codigo = codigo;
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
