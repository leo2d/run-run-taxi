package run.run.taxi;

import java.util.ArrayList;
import java.util.List;
import run.run.taxi.ValidaCPF;

public class Colaborador {

    private String nome;
    private String cpf;
    private Veiculo veiculo;
    private Cnh cnh;
    private int numeroVR;
    private Endereco endereco;
    private String dataAdmissao;
    private String dataDesligamento;
    private String telefoneFixo;
    private String telefoneMovel;
    private boolean funcionarioAtivo;

    public Colaborador(String nome, String cpf, int numeroVR, String telefoneFixo, 
            String telefoneMovel, String dataAdmissao, Cnh cnh, Veiculo veiculo,Endereco endereco) {
        this.nome = nome;
        this.setCpf(cpf);
        this.numeroVR = numeroVR;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.endereco = endereco;
        this.telefoneFixo = telefoneFixo;
        this.telefoneMovel = telefoneMovel;
        this.dataAdmissao = dataAdmissao;
        this.funcionarioAtivo = true;
    }

    public void setFuncionarioAtivo(boolean funcionarioAtivo) {
        this.funcionarioAtivo = funcionarioAtivo;
    }

    public boolean isFuncionarioAtivo() {
        return funcionarioAtivo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
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

    public final void setCpf(String cpf) {
        if (ValidaCPF.isCPF(cpf)) {
            this.cpf = cpf;
        }
    }

    public void setNumeroVR(int numeroVR) {
        this.numeroVR = numeroVR;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setCnh(Cnh cnh) {
        this.cnh = cnh;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(String dtaDesligamento) {
        this.dataDesligamento = dtaDesligamento;
    }
    
    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneMovel() {
        return telefoneMovel;
    }

    public void setTelefoneMovel(String telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
    }
}
