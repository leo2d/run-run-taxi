package run.run.taxi;

public class Colaborador {

    private String nome;
    private int cpf;
    private Veiculo veiculo;
    private Cnh cnh;
    private int numeroVR;

    public Colaborador(String nome, int cpf, int numeroVR) {
        this.nome = nome;
        this.cpf = cpf;
        //this.veiculo = new Veiculo();
        //this.cnh = new Cnh();
        this.numeroVR = numeroVR;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cnh getCnh() {
        return cnh;
    }

    public int getNumeroVR() {
        return numeroVR;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setNumeroVR(int numeroVR) {
        this.numeroVR = numeroVR;
    }

}
